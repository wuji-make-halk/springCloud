package com.square.service.impl;

import com.square.dao.AdminMapper;
import com.square.model.Admin;
import com.square.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/24
 * Description:
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public Admin login(Admin admin) {
        // 根据用户名查对象
        Admin admin1 = adminMapper.login(admin.getLoginname());
        boolean password = encoder.matches(admin.getPassword(), admin1.getPassword());
        if (admin1 != null && password) {
            return admin1;
        }
        return null;
    }
}
