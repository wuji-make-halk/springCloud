package com.square.service;

import com.square.model.NoFriend;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/9/1
 * Description:
 */
public interface NoFriendService {
    /**
     * 添加非好友
     *
     * @param userId
     * @param friendId
     * @return
     */
    int addNoFriend(String userId, String friendId);
}
