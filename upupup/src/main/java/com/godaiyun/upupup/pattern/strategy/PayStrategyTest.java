package com.godaiyun.upupup.pattern.strategy;

public class PayStrategyTest {

  public static void main(String[] args) {

    // 订单处理
    Order order = new Order("1", "1223123123", 321.45);

    // 支付方式

    order.pay(PayType.WEIXIN_PAY);



  }
}
