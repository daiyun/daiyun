package daiyun.clone;

import java.io.*;

public class User implements Cloneable, Serializable {

  public String name;
  public Email email;


  public User() {
  }

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Email getEmail() {
    return email;
  }

  public void setEmail(Email email) {
    this.email = email;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    User re = (User) super.clone();
    re.setEmail((Email) re.getEmail().clone());
    return re;
  }

  public User deepClone() throws IOException, ClassNotFoundException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    oos.writeObject(this);

    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(bais);
    return (User) ois.readObject();

  }
}
