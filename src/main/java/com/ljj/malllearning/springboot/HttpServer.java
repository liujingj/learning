package com.ljj.malllearning.springboot;

import org.springframework.stereotype.Component;

public class HttpServer implements Server{
    @Override
    public void start() {
        System.out.println("http服务启动中...");
    }

    @Override
    public void stop() {
        System.out.println("http服务关闭中...");
    }
}
