package com.xyw55.gof.template;

/**
 * Created by xiayiwei on 12/18/16.
 */
public class Main {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();

        // 匿名内部类

        BankTemplateMethod btm2 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("save monsy");
            }
        };

        btm2.process();
    }
}
