package com.jobhunting.plus;

/**
 * @description: 逻辑运算符测试
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-04-18 09:37
 **/
public class Main {

    public static void main(String[] args) {
        int a = 60;
        int c = ~a;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(c<<2));
        System.out.println(Integer.toBinaryString(c>>2));
        System.out.println(Integer.toBinaryString(c>>>2));


    }

}
