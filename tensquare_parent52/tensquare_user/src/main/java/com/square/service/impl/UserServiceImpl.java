package com.square.service.impl;

import com.square.dao.UserMapper;
import com.square.model.User;
import com.square.service.UserService;
import com.square.util.JwtUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/15
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    public void sendSms(String mobile) {
        // 产生一个6位随机数。
        String checkCode = RandomStringUtils.randomNumeric(6);
        //存储到redis缓存中
        redisTemplate.opsForValue().set("sms" + mobile, "checkCode", 2, TimeUnit.HOURS);
        // 给用户发一份
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("checkCode", checkCode);
        amqpTemplate.convertAndSend("sms", map);
        // 在控制台显示一份【方便测试】
        System.out.println("验证码为：" + checkCode);

    }

    @Override
    public void add(User user) {
        String randomNumeric = RandomStringUtils.randomNumeric(6);
        user.setId(randomNumeric);
        user.setFollowcount(0);
        user.setFanscount(0);
        user.setOnline(0L);
        user.setRegdate(new Date());
        user.setUpdatedate(new Date());
        user.setLastdate(new Date());
        user.setPassword(encoder.encode(user.getPassword()));
        userMapper.insertSelective(user);
    }

    @Override
    public User login(User user) {
        // 根据用户名查对象
        User user1 = userMapper.login(user.getNickname());
        boolean password = encoder.matches(user.getPassword(), user1.getPassword());
        if (user1 != null && password) {
            return user1;
        }
        return null;
    }

    @Override
    public void remove(String id) {
        String token = (String) request.getAttribute("claims_admin");
        if (token == null || "".equals(token)) {
            throw new RuntimeException("权限不足");
        }
        userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新好友的粉丝和用户关注
     *
     * @param x
     * @param userid
     * @param friendid
     */
    @Override
    @Transactional
    public void updateFanceAndFollow(int x, String userid, String friendid) {
        userMapper.updateFanscount(x, friendid);
        userMapper.updateFollowcount(x, userid);
    }
}
