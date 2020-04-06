package com.square.dao;


import com.square.model.Friend;

public interface FriendMapper {
    int deleteByPrimaryKey(Friend key);

    int insert(Friend record);

    int insertSelective(Friend record);

    Friend selectByPrimaryKey(Friend key);

    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
}