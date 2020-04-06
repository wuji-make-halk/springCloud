package com.square.service;

import com.square.model.User;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/15
 * Description:
 */
public interface UserService {

    /**
     * 发送验证码
     *
     * @param mobile
     */
    void sendSms(String mobile);

    void add(User user);

    User login(User user);

    void remove(String id);

    void updateFanceAndFollow(int x, String userid, String friendid);
}
