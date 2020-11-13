package com.ljj.malllearning;

class MallLearningApplicationTests {


    public static int getDrinks(int bottles, int change) {
        int total = bottles;
        int empty = bottles;
        while (empty >= change) {
            total += empty / change;
            empty = empty % change + empty / change;
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        getDrinks(5, 2);


//        String str = "[1,2,3]";
//        List<String> list = JSONObject.parseArray(str, String.class);
//        Map<String, String> map = JSONObject.parseObject(str, Map.class);
//        System.out.println(list);
//        System.out.println(map);
//
//
//        // TODO: 2020/11/2 直接调用和反射调用区别
//        //通过类加载器加载相应类对象
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        Class clazz = classLoader.loadClass("com.ljj.malllearning.service.RedisServiceImpl");
//        //获取类的默认构造器对象 并通过它实例化该对象
//        Constructor constructor = clazz.getDeclaredConstructor();
//        RedisServiceImpl redisService = (RedisServiceImpl) constructor.newInstance();
//        //通过反射方法设置属性
//        Method method = clazz.getMethod("set", String.class, String.class);
//        method.invoke(redisService, "key", "value");
//
//        //扩展类加载器
//        ClassLoader extApplication=classLoader.getParent();


    }

}
