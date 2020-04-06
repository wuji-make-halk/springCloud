package com.square.controller;

import com.square.entity.Result;
import com.square.entity.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: 吴宸煊
 * Date: Created in  2019/7/20
 * Description: 全局异常处理
 */
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result Exception(Exception e) {
        e.printStackTrace();
        return new Result(false, StatusCode.Error, e.getMessage());

    }
}
