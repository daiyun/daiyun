package daiyun.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {

  public static void main(String[] args) {
    try {
      Socket socket = new Socket("127.0.0.1", 8001);

      OutputStream outputStream = socket.getOutputStream();//获取一个输出流，向服务端发送信息
      InputStream inputStream = socket.getInputStream();

      outputStream.write("11111111111\n".getBytes());

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      outputStream.write("111111111112\n".getBytes());
      int length = inputStream.available();

      byte[] retBytes = new byte[length];
      inputStream.read(retBytes);

      System.out.println(new String(retBytes));

      socket.close();
      outputStream.close();
      inputStream.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
