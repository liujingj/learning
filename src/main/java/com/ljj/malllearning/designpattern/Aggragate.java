package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public interface Aggragate {
    void add(String str);

    MyIterator iterator();
}
