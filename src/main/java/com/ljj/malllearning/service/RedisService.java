package com.ljj.malllearning.service;

/**
 * @author ljj
 * @date 2020/9/27
 */
public interface RedisService {

    void set(String key, String value);

    String get(String key);
}
