package com.ljj.malllearning.springboot;

import org.springframework.stereotype.Component;

public class FtpServer implements Server{
    @Override
    public void start() {
        System.out.println("ftp服务启动中...");
    }

    @Override
    public void stop() {
        System.out.println("ftp服务关闭中...");
    }
}
