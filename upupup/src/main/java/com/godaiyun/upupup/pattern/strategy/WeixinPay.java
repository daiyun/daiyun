package com.godaiyun.upupup.pattern.strategy;

public class WeixinPay implements Payment {
  @Override
  public PayState pay(String uid, double amount) {
    System.out.println("微信支付");
    System.out.println("处理流程");
    return null;
  }
}
