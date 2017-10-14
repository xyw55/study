package oom;

/**
 * VM option: -verbose:gc -Xms20M -Xmx20M  -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError -Xss160k
 * Created by xiayiwei on 10/14/17.
 */
public class StackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackSOF stackSOF = new StackSOF();
        try {
            stackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length is " + stackSOF.stackLength);
            throw e;
        }
    }
}
