package com.xyw55.gof.adapter;

/**
 * Created by xiayiwei on 12/4/16.
 */
public class Main {

    public void test(Target target) {
        target.handlerReq();
    }

    public static void main(String[] args) {
        Main main = new Main();

        Adapter adapter = new Adapter();
        main.test(adapter);

        Adapter2 adapter2 = new Adapter2(new Adaptee());
        main.test(adapter2);

    }
}
