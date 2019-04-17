package daiyun.thread;

import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteData {

    public void writeData(PipedOutputStream output) {

        System.out.println("write data start ...");
        try {
            for (int i = 0; i < 300; i++) {
                String data = i + "";
                output.write(data.getBytes());
                System.out.println("write:" + data);
            }
            System.out.println("write data end!");
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void writeData(PipedWriter pipedWriter) {
        System.out.println("write data start");
        try {

            for (int i = 0; i < 300; i++) {
                String data = i + "data";
                pipedWriter.write(data);
                System.out.println("write:" + data);
            }
            System.out.println("data write end!");
            pipedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
