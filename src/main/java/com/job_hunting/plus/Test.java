package com.jobhunting.plus;

import java.io.*;
import java.util.*;
import java.util.LinkedList;


/**
 * @description:
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-06 14:13
 **/
public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //读取屏幕一行输入
        String input = br.readLine();
        //遍历获取单个值
        String[] in = input.split(" ");
        // 创建列表，并指定长度，避免可能产生的扩容
        LinkedList<String> out = new LinkedList<>();
        // 实现数组添加到列表中
        Collections.addAll(out, in);
        // list -> array
        List<String> toolList = new ArrayList<>(out.size());
        for (int j = 0; j < out.size(); j++) {
            //String添加"" int 添加-1;标识
            toolList.add(out.get(j));
        }
        toolList.set(0, "changed");
        System.out.println(toolList);
        System.out.println(out);
    }

}
