package com.xyw55.gof.singleton;

/**
 * 懒汉式单例模式
 * Created by xiayiwei on 11/27/16.
 */
public class SingletonDemo4 {
    private SingletonDemo4() {
        if (null != singleton) {
            throw new RuntimeException();
        }
    }
    private Singleton singleton;

    public synchronized Singleton getIntance() {
        if (null == singleton) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
