package com.square.controller;

import com.square.model.User;
import com.square.service.UserService;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import com.square.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/15
 * Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 发送短信验证码
     *
     * @return
     */
    @RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST)
    public Result sendSMS(@PathVariable String mobile) {
        userService.sendSms(mobile);
        return new Result(true, StatusCode.OK, "发送成功");
    }

    @RequestMapping(value = "/register/{code}", method = RequestMethod.POST)
    public Result register(@PathVariable String code, @RequestBody User user) {
        // 得到缓存中的验证码
        String checkCodeRedis = (String) redisTemplate.opsForValue().get("sms" + user.getMobile());
        if (checkCodeRedis.isEmpty()) {
            return new Result(false, StatusCode.Error, "请先获取手机验证码");
        }
        if (checkCodeRedis.equals(code)) {
            return new Result(false, StatusCode.Error, "请输入正确的验证码");
        }
        userService.add(user);
        return new Result(true, StatusCode.OK, "注册成功");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user) {
        User user1 = userService.login(user);
        if (user1 == null) {
            return new Result(false, StatusCode.LOGINERROR, "登陆失败");
        }
        String token = jwtUtil.createJWT(user1.getId(), user1.getMobile(), "user");
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("roles", "user");
        return new Result(true, StatusCode.OK, "登陆成功", map);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        userService.remove(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 更新粉丝数和关注数
     */
    @RequestMapping(value = "/{userid}/{friendid}/{x}", method = RequestMethod.PUT)
    public void updateFanscountAndFollowcount(@PathVariable String userid, @PathVariable String friendid, @PathVariable int x) {
        userService.updateFanceAndFollow(x, userid, friendid);
    }
}
