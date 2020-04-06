package com.square.service.impl;

import com.square.dao.ArticleMapper;
import com.square.model.Article;
import com.square.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/27
 * Description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public int update(String id) {
        int result = 0;
        result = articleMapper.updateState(id);
        return result;
    }

    @Override
    public int addThumbup(String id) {
        int result = 0;
        result = articleMapper.addThumber(id);
        return result;
    }

    @Override
    public Article findById(String articleId) {
        //从redis里面进行查询
        Article article = (Article) redisTemplate.opsForValue().get("articleId");
        if (null == article) {
            //再去数据库查询
            article = articleMapper.selectByPrimaryKey(articleId);
            // 并将查询到的数据保存到redis中
            redisTemplate.opsForValue().set("articleId", article, 1, TimeUnit.MINUTES);
        }

        return article;
    }

    @Override
    public int modify(Article article) {
        // 移除缓存的数据
        redisTemplate.delete(article.getId());
        int result = 0;
        result = articleMapper.updateByPrimaryKeySelective(article);
        return result;
    }

    @Override
    public int remove(String articleId) {
        // 移除缓存的数据
        redisTemplate.delete(articleId);
        int result = 0;
        result = articleMapper.deleteByPrimaryKey(articleId);
        return result;
    }
}
