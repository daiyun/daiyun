package com.daiyu.demo.springbootsecurity.exception;

public class AuthException extends Exception{
    private String msg;
    public AuthException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
