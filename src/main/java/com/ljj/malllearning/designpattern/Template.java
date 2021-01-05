package com.ljj.malllearning.designpattern;

import lombok.Data;

/**
 * @author ljj
 * @date 2021/1/4
 */
@Data
public class Template implements Cloneable {
    private String temName;
    private String temContent;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
