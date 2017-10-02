package com.xyw55.gof.adapter;

/**
 * 适配器(通过组合的方式是适配器)
 * Created by xiayiwei on 12/4/16.
 */
public class Adapter2 implements Target {
    private Adaptee adaptee;

    @Override
    public void handlerReq() {
        adaptee.handlerReq();
    }

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
