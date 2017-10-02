package com.xyw55.gof.singleton;

/**
 * 双重检查锁机制, jdk内部机制,导致其并不是单例模式,有时候会创建多个
 * Created by xiayiwei on 11/27/16.
 */
public class SingletonDemo3 {

    private SingletonDemo3() {
    }

    private Singleton singleton;

    public Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
