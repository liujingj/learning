package com.ljj.malllearning.designpattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ljj
 * @date 2021/1/7
 */
public class FlyweightFactory {
    //对象池
    private Map<String, ProvinceFlyweight> map = new HashMap<>();

    //获取享元对象
    public ProvinceFlyweight getFlyweight(String provinceName) {

        if (map.get(provinceName) != null) {
            return map.get(provinceName);
        }
        ProvinceFlyweight flyweight = new ProvinceFlyweight(provinceName);
        map.put(provinceName, flyweight);
        return flyweight;
    }
}
