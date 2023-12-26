package com.jobhunting.templates;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @description: 格式化操作
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-25 11:40
 **/
public class FormatOperations {

    {
        int i=100;
        // 10进制转2进制
        String binStr=Integer.toBinaryString(i);
    }

    {
        // %s 字符串
        // %d 十进制整数
        // %f 十进制浮点数
        // 格式化小数点，直接截断
        double d = 114.145;
        // 直接截断
        double v = Math.floor(d * 100) / 100;
        double w = Math.ceil(d * 100) / 100;
        // 格式化小数点，可四舍五入
        double de = 114.145;
        String.format("%.2f", de);
    }

    {
        // int 位数填充
        String.format("%010d", 25);
        // 字符串补0
        String.format("%4s", "AA").replace(" ","0");
    }

    // random类 随机数生成
    {
        Random random = new Random();
        // [0, 结束值)
        random.nextInt(10);
        // [0.0,1.0)
        random.nextDouble();
    }

    public static void main(String[] args) {
        System.out.println(String.format("%010d", 25));
        System.out.println(String.format("%4s", "AA").replace(" ","0"));
    }
}
