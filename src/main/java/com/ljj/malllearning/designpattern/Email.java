package com.ljj.malllearning.designpattern;

import lombok.Data;

/**
 * @author ljj
 * @date 2021/1/4
 */
@Data
public class Email implements Cloneable {
    private String title;
    private Template template;
    private static String receive;

    public Email() {
        System.out.println("构造方法");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
//        Email email = (Email) super.clone();
//        email.setTemplate((Template) email.getTemplate().clone());
//        return email;
    }
}
