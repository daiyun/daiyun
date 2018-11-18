package daiyun.clone;

import java.io.Serializable;

public class Email implements Cloneable, Serializable {

  public String content;

  public Email() {
  }

  public Email(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
