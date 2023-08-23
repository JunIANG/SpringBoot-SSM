package com.jay.controller;

import com.jay.exception.BusinessException;
import com.jay.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//异常拦截处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(Exception.class)  //拦截其他异常
    public Result doException(Exception ex) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        System.out.println("其他异常");
        return new Result(null, Code.SYSTEM_UNKNOWN_ERR, "系统繁忙，请稍后再试！");
    }

    @ExceptionHandler(SystemException.class)  //拦截系统异常
    public Result doSystemException(SystemException ex) {
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员
        System.out.println("系统异常");
        return new Result(null, ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(BusinessException.class)  //拦截业务异常
    public Result doBusinessException(BusinessException ex) {
        System.out.println("业务异常");
        return new Result(null, ex.getCode(), ex.getMessage());
    }

}
