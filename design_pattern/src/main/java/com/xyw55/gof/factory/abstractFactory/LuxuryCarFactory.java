package com.xyw55.gof.factory.abstractFactory;

/**
 * Created by xiayiwei on 11/27/16.
 */
public class LuxuryCarFactory implements CarFactory{

    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }
}
