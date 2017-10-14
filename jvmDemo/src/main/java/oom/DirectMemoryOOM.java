package oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 内存申请ok,配置有问题,未出现OOM
 * VM option: -verbose:gc -Xms20M -Xmx20M  -Xmn10M -XX:MaxDirectMemorySize=10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 * Created by xiayiwei on 10/14/17.
 */
public class DirectMemoryOOM {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1M);
        }

    }
}
