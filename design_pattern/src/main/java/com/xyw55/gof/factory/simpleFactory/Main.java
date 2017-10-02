package com.xyw55.gof.factory.simpleFactory;

import com.xyw55.gof.factory.Audi;
import com.xyw55.gof.factory.Bengchi;

/**
 * 简单工厂模式, 不满足OCP开闭原则
 * Created by xiayiwei on 11/27/16.
 */
public class Main {
    public static void main(String[] args) {
        Bengchi bengchi = (Bengchi) SimpleFactory.createCar("bengchi");
        Audi audi = (Audi) SimpleFactory.createAudi();
        audi.run();
        bengchi.run();
    }
}
