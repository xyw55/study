package com.xyw55.gof.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiayiwei on 12/17/16.
 */
public class President implements Mediator {
    private Map<String, Department> departmentMap = new HashMap<>();

    @Override
    public void register(String name, Department department) {
        this.departmentMap.put(name, department);
    }

    @Override
    public void commond(String departmentName) {
        Department d = this.departmentMap.get(departmentName);
        d.outAction();
    }
}
