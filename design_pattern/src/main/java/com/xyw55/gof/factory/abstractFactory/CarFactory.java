package com.xyw55.gof.factory.abstractFactory;

/**
 * Created by xiayiwei on 11/27/16.
 */
public interface CarFactory {
    Engine createEngine();

    Seat createSeat();

    Tyre createTyre();
}
