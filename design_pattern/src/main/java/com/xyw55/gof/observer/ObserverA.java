package com.xyw55.gof.observer;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 具体观察者
public class ObserverA implements Observer {

    private int myState;    //与subject保持同步

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject) subject).getState();
        System.out.println("update to " + myState);
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
