package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM option: -verbose:gc -Xms20M -Xmx20M  -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * 限制堆的大小
 * Created by xiayiwei on 10/14/17.
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
