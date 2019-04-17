package daiyun.thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

public class ReadData {

    public void doReadData(PipedInputStream input) {
        try {
            System.out.println("start read...");
            byte[] bytes = new byte[20];
            int readLength = input.read(bytes);
            while (readLength != -1) {
                System.out.println(new String(bytes));
                readLength = input.read(bytes);
            }
            System.out.println("read end");
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void doReadData(PipedReader pipedReader) {
        System.out.println("start read data...");

        try {

            char[] chars = new char[20];
            int readLength = pipedReader.read(chars);

            while (readLength != -1) {
                String readData = new String(chars);
                System.out.println(readData);
                readLength = pipedReader.read(chars);
            }
            System.out.println("data read end!");
            pipedReader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
