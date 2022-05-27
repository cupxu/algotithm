package com.job_hunting.templates;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 字符串操作
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-23 11:35
 **/
public class StringOperation {

    {
        //初始容量为16个字符 主要做增删查改 索引包头不包尾
        StringBuilder sb = new StringBuilder();

        sb.append("str");
        // 把原来index上的元素挪到新添加的元素位置后
        sb.insert(1, "str");

        sb.deleteCharAt(1);
        sb.delete(1, 2);

        sb.length();
        sb.capacity();
        sb.charAt(1);
        // 找不到返回-1
        sb.indexOf("char");
        sb.indexOf("char", 1);
        sb.lastIndexOf("str");
        sb.lastIndexOf("str", 1);
        sb.substring(1);
        sb.substring(1,3);

        sb.setCharAt(1,'c');
        sb.reverse();
        sb.replace(1, 2, "str");
        sb.toString();

    }

    {
        // 做替换、大小写变换、分割、清除空格、字符数组互换
        String str= new String();
        String string= new String();

        str.trim();
        str.toLowerCase();
        str.toUpperCase();
        str.compareTo(string);
        str.split(" ");
        str.replace("old", "new");
        str.replaceAll("%d","123");

        List<Character> list = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        str.chars().mapToObj(c -> (char) c).forEach(System.out::println);
        Collections.frequency(list, 'a');

        // 对字符串升序排列
        char[] ar = str.toCharArray();
        Arrays.sort(ar);
        String str11 = String.valueOf(ar);

    }


}

