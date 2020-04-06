package com.square.service.impl;

import com.square.dao.FriendMapper;
import com.square.model.Friend;
import com.square.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/9/1
 * Description:
 */
@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private FriendMapper friendMapper;


    @Override
    public int addFriend(String userId, String friendId) {
        int result = 0;
        Friend friend = new Friend();
        friend.setUserid(userId);
        friend.setFriendid(friendId);
        // 先判断userid 到 friendId 是否有数据，有的话，就是重复添加好友了。 返回0
        Friend friend1 = friendMapper.selectByPrimaryKey(friend);
        if (friend1 != null) {
            return 0;
        } else {
            // 直接添加好友，让好友表中的userid到friendId方向的type为0
            friend.setIsLike("0");
            result = friendMapper.insertSelective(friend);
        }
        return result;
    }
}
