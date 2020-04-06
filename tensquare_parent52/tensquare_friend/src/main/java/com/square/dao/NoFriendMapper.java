package com.square.dao;


import com.square.model.NoFriend;

public interface NoFriendMapper {
    int deleteByPrimary(NoFriend key);

    int insert(NoFriend record);

    int insertSelective(NoFriend record);

    NoFriend selectByPrimaryKey(NoFriend record);
}