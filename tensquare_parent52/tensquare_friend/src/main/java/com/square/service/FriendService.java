package com.square.service;

import com.square.model.Friend;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/9/1
 * Description:
 */
public interface FriendService {
    /**
     * \添加好友
     *
     * @param userId
     * @param friendId
     */
    int addFriend(String userId, String friendId);
}
