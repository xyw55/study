package com.xyw55.gof.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by xiayiwei on 12/10/16.
 */
public class StarHandler implements InvocationHandler {
    Star star;

    public StarHandler(Star star) {
        this.star = star;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        System.out.println("####");
        object = method.invoke(star, args);

        return object;
    }
}
