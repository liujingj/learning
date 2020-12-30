package com.ljj.malllearning;

/**
 * @author ljj
 * @date 2020/12/10
 */
public class CodeTest {
    public static void main(String[] args) {
        String str = "card";
        switch (str) {
            case "text":
                System.out.println("text");
                break;
            case "card":
            case "actionCard":
                System.out.println("card");
                break;
            case "feedCard":
                System.out.println("feedCard");
                break;
        }
    }
}
