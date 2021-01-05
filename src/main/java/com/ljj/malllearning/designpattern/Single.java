package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/4
 */
public class Single {
    //私有构造方法
    private Single() {

    }
    //静态方法提供实例的访问
    public static Single getInstance() {
        return SingletonHolder.single;
    }

    //通过静态内部类的静态属性进行初始化
    public static class SingletonHolder {
        private static final Single single = new Single();
    }

    public static void main(String[] args) {
        Single.getInstance();
    }
}
