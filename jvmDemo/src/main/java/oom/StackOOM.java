package oom;

/**
 * VM option: -verbose:gc -Xms20M -Xmx20M  -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError -Xss2M
 * Created by xiayiwei on 10/14/17.
 */
public class StackOOM {

    private void dontStop(){
        while (true) {
        }
    }

    public void stcakLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        StackOOM stackOOM = new StackOOM();
        stackOOM.stcakLeakByThread();
    }
}
