package com.square.controller;

import com.square.entity.Result;
import com.square.entity.StatusCode;
import com.square.model.Admin;
import com.square.service.AdminService;
import com.square.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/24
 * Description:
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody Admin admin) {
        Admin adminLogin = adminService.login(admin);
        if (adminLogin == null) {
            return new Result(false, StatusCode.LOGINERROR, "登陆失败");
        }
        // 生成令牌
        String token = jwtUtil.createJWT(adminLogin.getId(), adminLogin.getLoginname(), "admin");
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("role", "admin");
        return new Result(true, StatusCode.OK, "登陆成功", map);
    }
}
