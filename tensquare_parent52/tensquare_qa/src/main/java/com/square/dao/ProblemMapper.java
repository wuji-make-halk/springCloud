package com.square.dao;


import com.square.model.Problem;

import java.util.List;

public interface ProblemMapper {
    int deleteByPrimaryKey(String id);

    int insert(Problem record);

    int insertSelective(Problem record);

    Problem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Problem record);

    int updateByPrimaryKeyWithBLOBs(Problem record);

    int updateByPrimaryKey(Problem record);

    /**
     * 最新列表
     *
     * @param labelId
     * @return
     */
    List<Problem> newList(String labelId);

    /**
     * 最热列表
     *
     * @param labelId
     * @return
     */
    List<Problem> hotList(String labelId);

    /**
     * 等待列表
     *
     * @param labelId
     * @return
     */
    List<Problem> waitList(String labelId);

}