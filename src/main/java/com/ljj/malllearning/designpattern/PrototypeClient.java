package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/4
 */
public class PrototypeClient {
    public static void main(String[] args) throws CloneNotSupportedException {
        Email email = new Email();
        email.setTitle("title");
        Template template = new Template();
        template.setTemContent("content");
        template.setTemName("name");
        email.setTemplate(template);
        System.out.println("开始克隆");
        Email cloneEmail = (Email) email.clone();
        System.out.println("克隆完成");
        //修改原型的属性 观察克隆的对象属性是否变化
//        email.setTitle("title1");
//        template.setTemName("nameClone");
//        System.out.println("email=" + email);
//        System.out.println("cloneEmail=" + cloneEmail);
    }
}
