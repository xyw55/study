package com.xyw55.gof.template;

/**
 * Created by xiayiwei on 12/18/16.
 */
public abstract class BankTemplateMethod {
    public void takeNumber() {
        System.out.println("take number");
    }

    // 钩子方法
    public abstract void transact();

    public void evaluate() {
        System.out.println("反馈");
    }

    // 模板方法,子类不重写, final
    public final void process() {
        this.takeNumber();
        // 类似钩子,子类实现
        this.transact();

        this.evaluate();
    }
}
