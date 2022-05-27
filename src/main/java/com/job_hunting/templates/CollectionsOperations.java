package com.job_hunting.templates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @description: Collections操作
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-24 21:03
 **/
public class CollectionsOperations {

    {
        int i = 0,j = 0;
        int distance = 0;
        String string = null;
        String newString = null;
        List<String> list = new ArrayList<>();
        List<String> subList = new ArrayList<>();

        // -------------------增------------------------
        // 填充
        Collections.fill(list,string);

        // -------------------查------------------------
        Collections.min(list);
        Collections.max(list);
        Collections.binarySearch(list,string);
        // 返回指定元素出现的次数
        Collections.frequency(list,string);
        int start = list.indexOf(string);
        int end = list.lastIndexOf(string);
        Collections.indexOfSubList(list,subList);
        Collections.lastIndexOfSubList(list,subList);

        // -------------------改------------------------
        // 对list升序排列
        Collections.sort(list);
        // 随机排序
        Collections.shuffle(list);
        // 循环右移distance
        Collections.rotate(list,distance);
        // 反转
        Collections.reverse(list);
        // 交换ij元素
        Collections.swap(list,i,j);
        // 若要替换的值存在刚返回true
        Collections.replaceAll(list,string, newString);

    }
}
