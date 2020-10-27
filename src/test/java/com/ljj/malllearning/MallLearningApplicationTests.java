package com.ljj.malllearning;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class MallLearningApplicationTests {
    public static void main(String[] args) {
        String str = "[1,2,3]";
        List<String> list = JSONObject.parseArray(str, String.class);
        Map<String, String> map = JSONObject.parseObject(str, Map.class);
        System.out.println(list);
        System.out.println(map);
        ;
    }

}
