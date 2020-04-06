package com.square.dao;


import com.square.model.Article;

public interface ArticleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    /**
     * 更新状态
     *
     * @param id
     * @return
     */
    int updateState(String id);

    /**
     * 添加点赞数量
     *
     * @param id
     * @return
     */
    int addThumber(String id);
}