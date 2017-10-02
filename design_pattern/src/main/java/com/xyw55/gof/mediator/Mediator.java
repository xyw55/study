package com.xyw55.gof.mediator;

/**
 * Created by xiayiwei on 12/17/16.
 */
public interface Mediator {
    void register(String name, Department department);

    void commond(String departmentName);
}
