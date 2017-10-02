package com.xyw55.gof.factory.abstractFactory;

/**
 * Created by xiayiwei on 11/27/16.
 */
public interface Tyre {
    void revolve();
}

class LuxuryTyre implements Tyre {

    @Override
    public void revolve() {
        System.out.println("LuxuryTyre");
    }
}

class LowTyre implements Tyre {

    @Override
    public void revolve() {
        System.out.println("LowTyre");
    }
}