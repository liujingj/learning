package com.ljj.malllearning.service;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ljj
 * @date 2020/10/12
 */
@Component
public class OssServiceImpl implements OssService {

    @Override
    public Object policy() {
        //存储目录 签名有效期 文件大小 回调 提交节点 等
        return new Object();
    }

    @Override
    public Object callBack(HttpServletRequest request) {
        //将request中的参数 封装成对象返回给前端
        return new Object();
    }
}
