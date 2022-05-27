package com.job_hunting.algotithm.dp.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 正则表达式测试
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-05 11:55
 **/
public class Lambada {

    public static void main(String[] args) {
        String str = "a3344b33454a234a2q34";
        str = str.replaceAll("(.)\\d+?", "$1");
        System.out.println(str);

    }

        //Util two = "hello girl hi hot".replaceAll("(\\w+)\\s+(\\w+)", "$2 $1");


    public void test() {
        String regex = "((.)(.(.)))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("abc");
        System.out.println(matcher.matches());
        System.out.println(matcher.groupCount());
        while (matcher.find()) {
            System.out.println(matcher.group());
            //System.out.println(matcher.group(4));
        }
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(m.group());
            System.out.println(sub);
        }
    }

    public static void isRight(String p, String t) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        p = br.readLine();
        t = br.readLine();
        String regex = p.replaceAll("[?]",".").replaceAll("[*]","\\*");
        if (t.matches(regex)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}
