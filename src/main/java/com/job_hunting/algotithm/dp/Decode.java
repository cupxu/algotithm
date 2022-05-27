package com.jobhunting.algotithm.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-13 16:22
 **/
public class Decode {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().trim().toCharArray();
        int len = chars.length;
        int[] dp = new int[len];

        /*
        解析到第i个字符时，如果第i个字符单独解析则有dp[i-1]种解析方式如果第i个字符与i-1个字符一起解析，则需要i-1字符不为0，如果与i-1,i-2一起解析，则要求i-2字符不为0;
        所以解析到第i个字符的数量dp[i]=dp[i-1]+dp[i-2](能同时解析的数量)+dp[i-3](能同时解析的数量)；
        能同时解析时为1，不能同时解析时为0;
        */
        //dp[i]= (i>=1 ? dp[i-1] : 1) + (i>=2 ? dp[i-2] : 1) * (i>=1 ? chars[i-1]-'0' : 0) + (i>=3 ? dp[i-3] : 1) * (i>=2 ? chars[i-2]-'0' : 0);
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                dp[i] = 1;
            }
            if (i == 1) {
                if (chars[i - 1] == '1') {
                    dp[i] = 2;
                }else {
                    dp[i] = 1;
                }
            }
            if (i == 2) {
                // dp[i] = 解析3个 + 解析2个 + 解析1个
                if (chars[0] == '1') {
                // 可以3个一起解析
                    if (chars[1] == '1') {
                    // 可以后两个一起解析2个
                        dp[i] = 3;
                    }else {
                    // 不可以后两个一起解析2个
                        dp[i] = 2;
                    }
                }else {
                // 不可以3个一起解析
                    if (chars[1] == '1') {
                        // 可以后两个一起解析2个
                        dp[i] = 2;
                    }else {
                        // 不可以后两个一起解析2个
                        dp[i] = 1;
                    }
                }
            }
            if (i >= 3) {
                if (dp[i - 2] == '1') {
                    if (chars[i - 1] == '1') {
                        dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
                    }else {
                        dp[i] = dp[i-3] + dp[i-2];
                    }
                }else {
                    if (chars[i - 1] == '1'){
                        dp[i] = dp[i-2] + dp[i-1];
                    }else {
                        dp[i] = dp[i-1];
                    }
                }
            }
        }
        System.out.println(dp[len-1]);
    }
}



















