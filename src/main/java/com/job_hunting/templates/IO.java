package com.job_hunting.templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: cupxu
 * @create: 2022-05-21 20:15
 **/
public class IO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //读取屏幕一行输入
        String input = br.readLine();
    }
}
