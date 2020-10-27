package com.ljj.malllearning.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ljj
 * @date 2020/10/12
 */
public interface OssService {
    /**
     * 上传策略生成
     * @return
     */
    Object policy();

    /**
     * oss上传成功回调
     * @param request
     * @return
     */
    Object callBack(HttpServletRequest request);
}
