package com.xyw55.gof.singleton;

/**
 * 饿汉式单例模式,线程安全,不过每次类加载,就创建实例
 * Created by xiayiwei on 11/27/16.
 */
public class SingletonDemo5 {
    private SingletonDemo5() {

    }

    private static Singleton singleton = new Singleton();

    public Singleton getInstance() {
        return singleton;
    }
}
