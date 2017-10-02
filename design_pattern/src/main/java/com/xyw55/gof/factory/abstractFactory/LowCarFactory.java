package com.xyw55.gof.factory.abstractFactory;

/**
 * Created by xiayiwei on 11/27/16.
 */
public class LowCarFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new LowEngine();
    }

    @Override
    public Seat createSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre createTyre() {
        return new LowTyre();
    }
}
