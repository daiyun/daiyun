package daiyun.thread;

import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteDataThread extends Thread {

    private WriteData writeData;
    private PipedOutputStream outputStream;
    private PipedWriter pipedWriter;


    public WriteDataThread(WriteData writeData, PipedOutputStream outputStream) {
        this.writeData = writeData;
        this.outputStream = outputStream;
    }


    public WriteDataThread(WriteData writeData, PipedWriter pipedWriter) {
        this.writeData = writeData;
        this.pipedWriter = pipedWriter;
    }

    @Override
    public void run() {
//        writeData.writeData(outputStream);
        writeData.writeData(pipedWriter);
    }
}
