package com.xyw55.gof.proxy.staticProxy;

/**
 * Created by xiayiwei on 12/10/16.
 */
public class Main {
    public static void main(String[] args) {
        Star star = new RealStar();
        ProxyStar proxyStar = new ProxyStar(star);
        proxyStar.sing();
    }
}
