package com.ljj.malllearning.dto;

import lombok.Data;

/**
 * 日志封装类
 *
 * @author ljj
 * @date 2020/10/13
 */
@Data
public class WebLog {
    private String desc;
    private String userName;
    private Object result;
    private Long time;
}
