package com.ljj.malllearning.jvm;

/**
 * @author ljj
 * @date 2021/2/1
 */
public class InternTest {
    public static void main(String[] args) {
        // str1堆上分配  str1.intern() 常量池中原来没有 所以指向堆上的str1
        String str1 = new StringBuilder("你").append("好").toString();
        System.out.println(str1.intern() == str1);

        //str2堆上分配 str2.intern()常量池中已经有一个相同的常量str1
        String str2 = new StringBuilder("你").append("好").toString();
        System.out.println(str2.intern() == str2);

        System.out.println(str2.intern() == str1);

    }
}
