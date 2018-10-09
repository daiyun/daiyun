package daiyun.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
  private int port;

  public MySocketServer(int port) {
    this.port = port;
  }

  public static void main(String[] args) {
    MySocketServer server = new MySocketServer(8001);
    try {
      server.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void start() throws Exception {
    ServerSocket serverSocket = new ServerSocket(port);

    while (true) {
      final Socket socket = serverSocket.accept();
      Thread thread = new Thread(new Runnable() {
        public void run() {

          try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request;
            String response;

            while ((request = in.readLine()) != null) {
              if ("Done".equals(request)) {
                break;
              }

              response = processRequest(request);

              out.println(response);
            }
          } catch (Exception e) {

          }

        }
      });

      thread.start();
    }

  }

  public String processRequest(String request) {
    System.out.println(request);
    return request;
  }
}
