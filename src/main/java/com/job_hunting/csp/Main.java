package com.job_hunting.csp;

import java.io.*;

/**
 * @description:
 * @author: cupxu
 * @create: 2022-05-21 20:12
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //读取屏幕一行输入
        String input = br.readLine();
        String[] array = input.split(" ");
        int n = Integer.parseInt(array[0]);
        int k = Integer.parseInt(array[1]);
        int[] array1 = new int[k];
        int[] array2 = new int[k];
        // 读取所有输入
        for (int i = 0; i < k; i++) {
            String[] currentInput = br.readLine().split(" ");
            array1[i] = Integer.parseInt(currentInput[0]);
            array2[i] = Integer.parseInt(currentInput[1]);
        }
        System.out.println(compute(array1, array2, k));

    }

    /**
     *
     * @param list1 左侧
     * @param list2 右侧
     * @param k
     * @return
     */
    public static int compute(int[] list1, int[] list2, int k) {
        int result = 0;
        // i左侧从0开始 j右侧从1开始
        int j = 0;
        while (j < k) {
            if (j == 0) {
                if (list2[j] != 0) {
                    result++;
                    j++;
                }
            }else {
                j++;
            }
            int i = 0;
            result++;
            while (i < j && j < k) {
                if (list1[i] == list2[j] || list2[j] == 0) {
                    result--;
                    break;
                }else {
                    i++;
                }
            }
        }
        return result - 1;
    }
}
