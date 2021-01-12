package com.ljj.malllearning.designpattern;

import java.util.List;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class MyIteratorImpl<T> implements MyIterator<T> {
    private List<T> list;
    //游标
    private int cursor;

    public MyIteratorImpl(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return list.get(cursor++);
        }
        return null;

    }
}
