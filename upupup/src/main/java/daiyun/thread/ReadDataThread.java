package daiyun.thread;

import java.io.PipedInputStream;
import java.io.PipedReader;

public class ReadDataThread extends Thread {

    private ReadData readData;
    private PipedInputStream inputStream;
    private PipedReader pipedReader;

    public ReadDataThread(ReadData readData, PipedInputStream inputStream) {
        this.inputStream = inputStream;
        this.readData = readData;
    }

    public ReadDataThread(ReadData readData, PipedReader pipedReader) {
        this.readData = readData;
        this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
//        readData.doReadData(inputStream);
        readData.doReadData(pipedReader);
    }
}
