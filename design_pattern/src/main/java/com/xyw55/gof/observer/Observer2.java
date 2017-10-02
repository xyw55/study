package com.xyw55.gof.observer;

import java.util.*;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 通过java.util.Observer实现观察者
public class Observer2 implements java.util.Observer {
    private int myState;

    @Override
    public void update(Observable o, Object arg) {
        myState = (int) arg;
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
