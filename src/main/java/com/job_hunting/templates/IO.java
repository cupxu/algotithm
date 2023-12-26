package com.job_hunting.templates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> collect = Arrays.stream(input.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Double> collect1 = Arrays.stream(input.split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
