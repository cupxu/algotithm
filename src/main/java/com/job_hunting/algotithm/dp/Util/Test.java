package com.job_hunting.algotithm.dp.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @description:
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-08 14:49
 **/
public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //读取屏幕一行输入
        String input = br.readLine();
        StringBuilder builder = new StringBuilder(input);
        builder.charAt(0);
        char[] charArr = input.toCharArray();

        int len = input.length();
        Arrays.sort(charArr);
    }

}
