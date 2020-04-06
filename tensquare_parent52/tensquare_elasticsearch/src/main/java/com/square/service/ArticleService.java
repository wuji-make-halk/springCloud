package com.square.service;

import com.square.dao.ArticleDao;
import com.square.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/12
 * Description:
 */
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public void save(Article article) {
        articleDao.save(article);
    }
}
