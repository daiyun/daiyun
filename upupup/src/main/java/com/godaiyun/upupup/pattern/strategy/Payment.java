package com.godaiyun.upupup.pattern.strategy;

public interface Payment {
  PayState pay(String uid, double amount);
}
