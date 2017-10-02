package com.xyw55.gof.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 目标对象
public class Subject {
    protected List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // 通知观察者更新
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}
