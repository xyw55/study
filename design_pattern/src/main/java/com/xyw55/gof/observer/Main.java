package com.xyw55.gof.observer;

/**
 * Created by xiayiwei on 12/18/16.
 */
// 客户端
public class Main {
    public static void main(String[] args) {
        // 创建具体通知者
        ConcreteSubject subject = new ConcreteSubject();

        // 创建多个观察者
        ObserverA observer1 = new ObserverA();
        ObserverA observer2 = new ObserverA();
        ObserverA observer3 = new ObserverA();

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);
        subject.registerObserver(observer3);

        // 改变subject的状态值
        subject.setState(1);

        System.out.println(observer1.getMyState());
        System.out.println(observer2.getMyState());
        System.out.println(observer3.getMyState());

    }
}
