package com.square.dao;


import com.square.model.Gathering;

public interface GatheringMapper {
    int deleteByPrimaryKey(String id);

    int insert(Gathering record);

    int insertSelective(Gathering record);

    Gathering selectByPrimaryKey(String id);

    int updateByPrimaryKey(Gathering record);
}