package com.xyw55.gof.observer;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 通过javase 的java.util.Observable, java.util.Observer实现
public class Main2 {
    public static void main(String[] args) {
        ConcreteSubject2 subject2 = new ConcreteSubject2();

        Observer2 observer1 = new Observer2();
        Observer2 observer2 = new Observer2();
        Observer2 observer3 = new Observer2();

        subject2.addObserver(observer1);
        subject2.addObserver(observer2);
        subject2.addObserver(observer3);

        subject2.setState(10);

        System.out.println(observer1.getMyState());
        System.out.println(observer2.getMyState());
        System.out.println(observer3.getMyState());
    }
}
