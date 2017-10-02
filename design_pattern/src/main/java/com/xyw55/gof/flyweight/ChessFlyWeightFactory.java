package com.xyw55.gof.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiayiwei on 12/11/16.
 */
// 享元工厂类
public class ChessFlyWeightFactory {
    // 享元池
    private static Map<String, ChessFlyWeight> map = new HashMap<>();

    public static ChessFlyWeight getChess(String color) {
        if (map.get(color) != null) {
            return map.get(color);
        } else {
            ChessFlyWeight cfw = new ConcreteChess(color);
            map.put(color, cfw);
            return cfw;
        }
    }

}
