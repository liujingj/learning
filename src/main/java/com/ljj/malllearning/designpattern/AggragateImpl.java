package com.ljj.malllearning.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class AggragateImpl implements Aggragate {
    List<String> list;

    public AggragateImpl(List<String> list) {
        this.list = list;
    }

    @Override
    public void add(String str) {
        list.add(str);
    }

    @Override
    public MyIterator iterator() {
        return new MyIteratorImpl(list);
    }
}
