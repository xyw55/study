package com.xyw55.gof.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * Created by xiayiwei on 12/10/16.
 */
public class Main {
    public static void main(String[] args) {
        Star star = new RealStar();
        StarHandler starHandler = new StarHandler(star);
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[] {Star.class}, starHandler);
        proxy.sing();

    }
}
