package com.square.dao;


import com.square.model.Column;

public interface ColumnMapper {
    int deleteByPrimaryKey(String id);

    int insert(Column record);

    int insertSelective(Column record);

    Column selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);
}