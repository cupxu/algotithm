package com.job_hunting.baidu.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 限制最长子串
 * @author: cupxu
 * @create: 2022-04-29 16:44
 **/
public class LongestSubString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 读取屏幕一行输入
        int len = Integer.parseInt(br.readLine());
        String input = br.readLine().replace(" ","");
        System.out.println(getLength(input,len));
    }

    public static int getLength(String string,int len) {
        // 以下标i为起点的 满足条件的序列长度

        int curIndex,curData;
        // 结果
        int res = 0;
        int start = 0;
        while (start < len) {
            int max = 0;
            int min = 100001;
            for (curIndex = start; curIndex < len; curIndex++) {
                curData = Integer.parseInt(String.valueOf(string.charAt(curIndex)));
                max = Math.max(max, curData);
                min = Math.min(min, curData);
                if ((max - min) > 1) {
                    res = Math.max(res, curIndex - start);
                    break;
                }
                if (curIndex == len - 1){
                    res = Math.max(res, curIndex - start + 1);
                    break;
                }
            }
            start++;
        }
        return res;
    }
}
