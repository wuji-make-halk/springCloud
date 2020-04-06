package com.square.service;

import com.square.model.Admin;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/8/24
 * Description:
 */
public interface AdminService {
    /**
     * 登陆
     *
     * @param admin
     * @return
     */
    Admin login(Admin admin);
}
