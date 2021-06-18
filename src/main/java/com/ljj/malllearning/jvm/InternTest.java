package com.ljj.malllearning.jvm;

/**
 * @author ljj
 * @date 2021/2/1
 */
public class InternTest {
    public static void main(String[] args) {

        String str1 = new StringBuilder("ab").append("c").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("abc").toString();
        System.out.println(str2.intern() == str2);

        System.out.println(str2.intern() == str1);

        //String str1 = new StringBuilder("abc").toString();
        //System.out.println(str1.intern() == str1);
        //
        //String str2 = new StringBuilder("abc").toString();
        //System.out.println(str2.intern() == str2);
        //
        //System.out.println(str2.intern() == str1);

        //String str1 = new String("abc");
        //System.out.println(str1.intern() == str1);
        //String str2 = new String("abc");
        //System.out.println(str2.intern() == str2);
        //System.out.println(str2.intern() == str1);

    }
}
