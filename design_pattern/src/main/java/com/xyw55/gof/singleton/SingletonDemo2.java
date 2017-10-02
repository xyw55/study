package com.xyw55.gof.singleton;

/**
 * 静态内部类实现单例模式
 * Created by xiayiwei on 11/27/16.
 */
public class SingletonDemo2 {
    private SingletonDemo2() {
    }

    private static class SingletonHandler {
        public static final Singleton INSTANCE = new Singleton();
    }

    public Singleton getInstance() {
        return SingletonHandler.INSTANCE;
    }


}
