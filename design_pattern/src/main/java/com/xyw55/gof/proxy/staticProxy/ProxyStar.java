package com.xyw55.gof.proxy.staticProxy;

/**
 * Created by xiayiwei on 12/10/16.
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void sing() {
        System.out.println("proxy sing");
        star.sing();
    }
}
