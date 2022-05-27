package com.job_hunting.baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 安排车辆
 * @author: cupxu
 * @create: 2022-04-29 14:47
 **/
public class CarArrangement {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //读取屏幕一行输入
        int N = Integer.parseInt(br.readLine());

    }

    public static int arrangeCar(int len, List<Integer> students) {
        // 采用哈希表 存放对应 人数为1 2 3 4的小组分别有多少
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < len; i++) {
            // 存在以nums[i]为键的元素，那么
            map.putIfAbsent(students.get(i), 0);
            map.put(students.get(i), map.get(students.get(i)) + 1);
        }// 获得对应人数的小组数

        // 至少有4个人的小组 多少个 注意不是用下标获取对应数据
        int result = map.get(Integer.valueOf(4));
        int size = map.size();
        // 最小的和最大的拼 拼完再和次小的拼 直到自己和自己拼
        for (int i = 0; i < map.size()/2; i++) {
            for (int j = map.size() - 2; j >= i; j--) {
                int small = map.get(i);
                int big = map.get(j);

                if (small <= big) {
                    result += small;
                    map.put(i, 0);
                    map.put(j, big - small);
                } else{
                    result += big;
                    map.put(i, small - big);
                    map.put(j, 0);
                }
            }
        }
        return -1;
    }



}
