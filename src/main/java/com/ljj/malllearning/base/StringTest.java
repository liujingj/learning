package com.ljj.malllearning.base;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.apache.commons.lang3.StringUtils;

/**
 * @author ljj
 * @date 2021/6/28
 */
public class StringTest {
    public static void main(String[] args) {
        //Object[] objects = new Object[] {"测试日志"};
        //objects[0] = StringUtils.join(objects[0], ",", "新的参数"+1);
        //System.out.println(Arrays.toString(objects));
        List<JSONObject> wfList = JSONArray.parseArray("[]", JSONObject.class);
        Map<String, Long> wfMap = wfList.stream().collect(
            Collectors.toMap(v -> v.getString("1"),
                v -> v.getLong("2")));
        System.out.println(wfMap);

    }
}
