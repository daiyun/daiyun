package daiyun.thread;

import java.io.*;

public class ThreadRun {

    public static void main(String[] args) {

        try {

            WriteData writeData = new WriteData();
            ReadData readData  = new ReadData();

            PipedOutputStream outputStream = new PipedOutputStream();
            PipedInputStream inputStream = new PipedInputStream();

//            outputStream.connect(inputStream);
//            inputStream.connect(outputStream);

            PipedReader pipedReader = new PipedReader();
            PipedWriter pipedWriter = new PipedWriter();

            pipedReader.connect(pipedWriter);

//            WriteDataThread writeDataThread = new WriteDataThread(writeData, outputStream);
            WriteDataThread writeDataThread = new WriteDataThread(writeData, pipedWriter);
//            ReadDataThread readDataThread = new ReadDataThread(readData, inputStream);
            ReadDataThread readDataThread = new ReadDataThread(readData, pipedReader);

            readDataThread.start();

            writeDataThread.start();
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

}
