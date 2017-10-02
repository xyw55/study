package com.xyw55.gof.factory.abstractFactory;

/**
 * Created by xiayiwei on 11/27/16.
 */
public interface Seat {
    void message();
}

class LuxurySeat implements Seat {

    @Override
    public void message() {
        System.out.println("LuxurySeat");
    }
}


class LowSeat implements Seat {

    @Override
    public void message() {
        System.out.println("LowSeat");
    }
}
