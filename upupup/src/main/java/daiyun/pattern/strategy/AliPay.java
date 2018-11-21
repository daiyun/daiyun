package daiyun.pattern.strategy;

public class AliPay implements Payment {
  @Override
  public PayState pay(String uid, double amount) {

    System.out.println("使用支付宝支付订单");

    System.out.println("处理流程");
    return new PayState(200, "成功", amount);
  }
}
