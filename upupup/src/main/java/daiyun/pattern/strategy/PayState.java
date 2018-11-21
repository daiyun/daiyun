package daiyun.pattern.strategy;

public class PayState {

  private int code;
  private Object data;
  private String msg;

  public PayState(int code, String msg,Object data) {
    this.code = code;
    this.data = data;
    this.msg = msg;
  }

  public String toString() {

    return "status：" + code + "，msg:" + msg + ",data:" + data;
  }
}
