package com.square.service;

import com.square.model.Article;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/27
 * Description:
 */
public interface ArticleService {
    /**
     * 审核
     *
     * @param id
     * @return
     */
    int update(String id);

    /**
     * 文章点赞数
     *
     * @param id
     * @return
     */
    int addThumbup(String id);

    /**
     * 根据Id查询
     *
     * @param articleId
     * @return
     */
    Article findById(String articleId);

    /**
     * 修改
     *
     * @param article
     * @return
     */
    int modify(Article article);

    /**
     * 删除
     *
     * @param articleId
     * @return
     */
    int remove(String articleId);
}
