package com.ljj.malllearning.concurrent;

import java.util.concurrent.Exchanger;

/**
 * @author ljj
 * @date 2021/3/2
 */
public class ExchangerTest {

    public static void main(String[] args) throws InterruptedException {

        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(() -> {
            String a = "123";
            try {
                exchanger.exchange(a);
            } catch (InterruptedException e) {
            }
        }).start();


        new Thread(() -> {
            String b = "123";
            try {
                String a = exchanger.exchange(null);
                System.out.println(a.equals(b));
            } catch (InterruptedException e) {
            }
        }).start();

    }
}
