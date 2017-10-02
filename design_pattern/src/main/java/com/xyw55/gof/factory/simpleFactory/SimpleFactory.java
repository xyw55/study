package com.xyw55.gof.factory.simpleFactory;

import com.xyw55.gof.factory.Audi;
import com.xyw55.gof.factory.Bengchi;
import com.xyw55.gof.factory.Car;

/**
 * 简单工厂模式, 不满足OCP开闭原则
 * Created by xiayiwei on 11/27/16.
 */
public class SimpleFactory {
    // 第一种方式
    public static Car createCar(String type) {
        if ("audi".equals(type)) {
            return new Audi();
        } else if ("bengchi".equals(type)) {
            return new Bengchi();
        } else {
            return null;
        }
    }


    // 第二种
    public static Car createAudi() {
        return new Audi();
    }

    public static Car createBengchi() {
        return new Bengchi();
    }
}
