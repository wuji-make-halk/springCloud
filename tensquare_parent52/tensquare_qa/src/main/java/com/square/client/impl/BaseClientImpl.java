package com.square.client.impl;

import com.square.client.BaseClient;
import com.square.entity.Result;
import com.square.entity.StatusCode;
import org.springframework.stereotype.Component;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/9/3
 * Description:
 */
@Component
public class BaseClientImpl implements BaseClient {
    @Override
    public Result findById(String labelId) {
        return new Result(false, StatusCode.Error, "熔断器启动了");
    }
}
