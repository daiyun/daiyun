package daiyun.vm;

/**
 * @author godai
 * @date 2021/8/15 16:11
 * @description
 */
// -XX:+TraceClassLoading
    // -XX:PrintCommandLineFlags
    // -XX:+UseSerialGC
    // -XX:+UseParNewGC
    // -XX:+UseParallelGC
    // -XX:+UseParallelOldGC
    // -XX:+UseG1GC
public class ClassLoadingTrace {

    public static void main(String[] args) {
        System.out.println("-XX:+TraceClassLoading");
    }
}
