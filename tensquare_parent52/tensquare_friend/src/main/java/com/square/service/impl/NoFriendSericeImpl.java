package com.square.service.impl;

import com.netflix.discovery.converters.Auto;
import com.square.dao.NoFriendMapper;
import com.square.model.NoFriend;
import com.square.service.NoFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/9/1
 * Description:
 */
@Service
public class NoFriendSericeImpl implements NoFriendService {
    @Autowired
    private NoFriendMapper noFriendMapper;

    @Override
    public int addNoFriend(String userId, String friendId) {
        NoFriend noFriend = new NoFriend();
        noFriend.setUserid(userId);
        noFriend.setFriendid(friendId);
        // 是否已经是好友
        NoFriend noFriend1 = noFriendMapper.selectByPrimaryKey(noFriend);
        if (noFriend != null) {
            return 0;
        }
        int result = noFriendMapper.insertSelective(noFriend);
        return result;
    }
}
