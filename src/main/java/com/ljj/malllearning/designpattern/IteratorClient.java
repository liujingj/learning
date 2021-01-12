package com.ljj.malllearning.designpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class IteratorClient {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        AggragateImpl aggragate = new AggragateImpl(list);
        MyIterator myIterator = aggragate.iterator();
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

    }
}
