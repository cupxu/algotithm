package com.jobhunting.newcoder.meituan;

import java.io.*;
/**
 * @description:
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-14 11:28
 **/

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int count = 0;
        for (int i = a; i <= b; i++) {
            int left = Integer.parseInt(String.valueOf(i).substring(0, 2));
            int mid = Integer.parseInt(String.valueOf(i).substring(2, 4));
            int right = Integer.parseInt(String.valueOf(i).substring(4, 6));
            if (left + mid == right && isDif(i)) {
                count++;
                System.out.println("-----------------------");
            }
            System.out.print(left);
            System.out.print(" ");
            System.out.print(mid);
            System.out.print(" ");
            System.out.println(right);
        }
        System.out.println(count);
    }

    static boolean isDif(int val) {
        String str = String.valueOf(val);
        return false;
    }
}



