package com.xyw55.gof.singleton;

/**
 * 枚举实现单例模式
 * Created by xiayiwei on 11/27/16.
 */
public enum SingletonDemo1 {
    INSTANCE,;

    private Singleton singletonClass;

    SingletonDemo1(){
        singletonClass = new Singleton();
    }

    public Singleton getInstance() {
        return singletonClass;
    }


    public static void main(String[] args) {
        SingletonDemo1 instance = SingletonDemo1.INSTANCE;
        Singleton singletonClass = instance.getInstance();

    }
}
