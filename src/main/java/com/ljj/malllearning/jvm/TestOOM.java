package com.ljj.malllearning.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljj
 * @date 2021/1/19
 */
public class TestOOM {
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    public static class OOMObject {
    }
}
