package com.xyw55.gof.state;

/**
 * Created by xiayiwei on 12/18/16.
 */
public class CheckedInState implements State {
    @Override
    public void handle() {
        System.out.println("room is check in");
    }
}
