package com.jobhunting.string;

/**
 * @description: 测试
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-23 11:43
 **/
public class TestString {
    public static void main(String args[]) {
        String str = "012345678";
        System.out.println(new StringBuilder(str).insert(1,"str"));

    }

}
