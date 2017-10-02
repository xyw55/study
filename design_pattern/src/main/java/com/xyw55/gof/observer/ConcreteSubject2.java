package com.xyw55.gof.observer;

import java.util.Observable;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 通过java.util.Observable实现目标对象
public class ConcreteSubject2 extends Observable {
    private int state;

    public void setState(int state) {
        this.state = state;
        setChanged();
        notifyObservers(state);
    }
}
