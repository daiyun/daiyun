package daiyun.pattern.strategy;

public interface Payment {
  PayState pay(String uid, double amount);
}
