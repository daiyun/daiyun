package daiyun.vm;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20m -Xmx20m
 * -XX:+PrintGC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintGCDetails -XX:+PrintGCDateStamps
 * -Xloggc:E://daiyu//upupup//gc.log
 */
public class TestOOM {
    private String str;

    public static void main(String[] args) {
        TestOOM testOOM = new TestOOM(System.currentTimeMillis() + "");
        testOOM.heapOOM();
    }

    public TestOOM(String str) {
        this.str = str;
    }

    public void heapOOM(){
        List<TestOOM> oomList = new ArrayList<>();

        while (true){
            oomList.add(new TestOOM(System.currentTimeMillis()+""));
        }
    }
}
