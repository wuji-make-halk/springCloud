package com.square.dao;


import com.square.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(String nickname);

    void updateFanscount(int x, String friendid);

    void updateFollowcount(int x, String userid);
}