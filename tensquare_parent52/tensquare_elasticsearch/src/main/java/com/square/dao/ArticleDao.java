package com.square.dao;

import com.square.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/12
 * Description:
 */
public interface ArticleDao extends ElasticsearchRepository<Article, String> {
}
