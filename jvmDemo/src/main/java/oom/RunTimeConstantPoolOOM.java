package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * java 1.6有效, 1.7对常量池移到了堆中,
 * java8 -XX:PermSize=10M -XX:MaxPermSize=10M 不适用
 *  VM option: -verbose:gc -Xms20M -Xmx20M  -Xmn10M -XX:PermSize=10M -XX:MaxPermSize=10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * Created by xiayiwei on 10/14/17.
 */
public class RunTimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
