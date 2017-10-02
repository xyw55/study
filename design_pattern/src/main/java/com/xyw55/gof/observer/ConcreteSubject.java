package com.xyw55.gof.observer;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 具体目标对象
public class ConcreteSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObservers();
    }
}
