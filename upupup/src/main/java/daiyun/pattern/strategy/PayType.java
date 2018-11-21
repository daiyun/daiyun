package daiyun.pattern.strategy;

public enum PayType {
  ALI_PAY(new AliPay()), WEIXIN_PAY(new WeixinPay());
  private Payment payment;

  PayType(Payment payment) {
    this.payment = payment;
  }

  public Payment get() {
    return this.payment;
  }
}
