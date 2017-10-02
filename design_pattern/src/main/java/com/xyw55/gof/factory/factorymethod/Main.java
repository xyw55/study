package com.xyw55.gof.factory.factorymethod;

import com.xyw55.gof.factory.Audi;
import com.xyw55.gof.factory.Bengchi;

/**
 * 工厂方法模式
 * 通过增加类,增加factory,结构复杂
 * Created by xiayiwei on 11/27/16.
 */
public class Main {
    public static void main(String[] args) {
        Audi audi = (Audi) new AudiFactory().createCar();
        Bengchi bengchi = (Bengchi) new BengchiFactory().createCar();
        audi.run();
        bengchi.run();
    }
}
