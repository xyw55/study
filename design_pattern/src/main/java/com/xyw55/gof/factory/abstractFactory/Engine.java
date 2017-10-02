package com.xyw55.gof.factory.abstractFactory;

/**
 * Created by xiayiwei on 11/27/16.
 */
public interface Engine {
    void run();

    void start();
}

class LuxuryEngine implements Engine {

    @Override
    public void run() {
        System.out.println("LuxuryEngine");
    }

    @Override
    public void start() {

    }
}

class LowEngine implements Engine {

    @Override
    public void run() {
        System.out.println("LowEngine");
    }

    @Override
    public void start() {

    }
}
