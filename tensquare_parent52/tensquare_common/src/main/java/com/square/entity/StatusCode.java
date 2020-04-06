package com.square.entity;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/18
 * Description:
 */
public class StatusCode {
    public static final int OK = 200; //成功
    public static final int Error = 201; // 失败
    public static final int LOGINERROR = 202; // 用户名或者密码错误
    public static final int ACCESSERROR = 203; // 权限不足
    public static final int REMOTERROR = 204; // 远程调用失败
    public static final int REPERROR = 205; // 重复操作
}
