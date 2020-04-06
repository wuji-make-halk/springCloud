package com.square.controller;

import com.square.client.UserClient;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import com.square.service.FriendService;
import com.square.service.NoFriendService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/9/1
 * Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/friend")
public class FriendController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FriendService friendService;
    @Autowired
    private NoFriendService noFriendService;

    @Autowired
    private UserClient userClient;

    /**
     * 添加好友或者添加非好友
     *
     * @param friendid
     * @param type
     * @return
     */
    @RequestMapping(value = "/like/{friendid}/{type}", method = RequestMethod.POST)
    public Result addFriend(@PathVariable("friendid") String friendid, @PathVariable("type") String type) {
        System.out.println("测试数据");
        // 验证是否登陆
        Claims claims = (Claims) request.getAttribute("claims_user");
        if (claims == null) {
            // 说明当前用户没有user角色
            return new Result(false, StatusCode.LOGINERROR, "权限不足");
        }
        // 得到当前用户的ID
        String userId = claims.getId();

        // 判断是添加好友，还是添加非好友
        if (type != null) {
            if (type.equals("1")) {
                // 添加好友
                int result = friendService.addFriend(userId, friendid);
                if (result == 0) {
                    return new Result(false, StatusCode.Error, "不能重复添加好友");
                }
                if (result == 1) {
                    userClient.updateFanscountAndFollowcount(userId, friendid, 1);
                    return new Result(true, StatusCode.OK, "添加好友成功");
                }
            } else {
                // 添加非好友
                int result = noFriendService.addNoFriend(userId, friendid);
                if (result == 0) {
                    return new Result(false, StatusCode.Error, "不能重复添加非好友");
                }
                if (result == 1) {
                    return new Result(true, StatusCode.OK, "添加非好友成功");
                }
            }
            return new Result(false, StatusCode.Error, "参数异常");
        } else {
            return new Result(false, StatusCode.Error, "参数异常");
        }
    }
}
