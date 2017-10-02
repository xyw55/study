package com.xyw55.gof.proxy.dynamicProxy;

/**
 * Created by xiayiwei on 12/10/16.
 */
public class RealStar implements Star {
    @Override
    public void sing() {
        System.out.println("real sing");
    }
}
