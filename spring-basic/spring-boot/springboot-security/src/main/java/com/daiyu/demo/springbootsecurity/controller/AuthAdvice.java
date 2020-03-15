package com.daiyu.demo.springbootsecurity.controller;

import com.daiyu.demo.springbootsecurity.bean.R;
import com.daiyu.demo.springbootsecurity.exception.AuthException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class AuthAdvice {
    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public R handleAuthException(final AuthException ex) {
        R rt = new R();
        rt.setRetCode("-1");
        rt.setRetMsg(ex.getMessage());
        return rt;
    }
}
