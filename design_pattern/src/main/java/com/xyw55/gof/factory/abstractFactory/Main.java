package com.xyw55.gof.factory.abstractFactory;

/**
 * 抽象工厂模式
 * 不增加产品,增加产品族
 * Created by xiayiwei on 11/27/16.
 */
public class Main {
    public static void main(String[] args) {
        LowCarFactory lowCarFactory = new LowCarFactory();
        LuxuryCarFactory luxuryCarFactory = new LuxuryCarFactory();
    }

}
