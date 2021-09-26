package com.ljj.malllearning.springboot;

public interface Server {

    void start();
    void stop();

    enum Type{
        HTTP,
        FTP
    }
}
