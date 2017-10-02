package com.xyw55.gof.state;

/**
 * Created by xiayiwei on 12/18/16.
 */
public class BookSate implements State {
    @Override
    public void handle() {
        System.out.println("room is booked");
    }
}
