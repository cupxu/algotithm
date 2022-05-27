package com.jobhunting.templates;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @description: Map操作
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-24 16:19
 **/
public class MapOperations {

    {
        Object object = new Object();
        Map map1 = new HashMap<>();
        Map map2 = new TreeMap();
        Map map3 = new LinkedHashMap();

        map1.put("string", object);
        map1.remove(object);
        map1.isEmpty();
        // 如果指定的键尚未与某个值相关联（或映射到 null ）将其与给定值相关联并返回 null ，否则返回当前值。
        map1.putIfAbsent(1, object);

        for (Object key : map1.keySet()) {
            Object value = map1.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
