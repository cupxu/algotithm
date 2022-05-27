package com.jobhunting.companies.meituan;

import java.io.*;
/**
 * @Description: 计算并保存所有分组方式下的 score 值，取最大值 优化方向 -> 循环计算并 始终存储一组最好的值
 * @Param:
 * @return:
 * @Author: xulifeng
 * @Date: 3/10/2022
 */
public class MeituanCar2 {
    // 原始分配表
    static double[][] score;
    // 最终分配结果
    static double[][] bestPath;
    // 当前分配方式
    static double[][] curPath;
    // 最大score
    static double maxScore = 0;
    // 订单数
    static int orderNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        orderNum = Integer.parseInt(br.readLine());
        score = new double[orderNum][orderNum];
        bestPath = new double[orderNum][orderNum];
        curPath = new double[orderNum][orderNum];
        // 填充score、bestPath、curPath
        for (int i = 0; i < orderNum; i++) {
            String[] oneRowScore = br.readLine().split(" ");
            for (int j = 0; j < orderNum; j++) {
                score[i][j] = Double.parseDouble(oneRowScore[j]);
                bestPath[i][j] = 0;
                curPath[i][j] = 0;
            }
        }
        //从第0行开始递归
        backTracing(0, orderNum);
        System.out.printf("%.2f",maxScore);
        System.out.println();

        for (int i = 0; i < orderNum; i++) {
            for (int j = 0; j < orderNum; j++) {
                if (bestPath[i][j] != 0) {
                    // +1是因为订单 车是从1开始 而数组从零开始
                    System.out.print(i+1);
                    System.out.print(" ");
                    System.out.println(j+1);
                }
            }
        }
    }
    /**
     * @Description: 回溯算法 检查这个位置是否还能存放
     * @Param: 当前行curRow 总列数
     * @return:
     * @Author: xulifeng
     * @Date: 3/9/2022
     */
    public static void backTracing(int curRow, int totalCol) {
        // 遍历完所有行时 row 和 col 大小一样
        if (curRow == orderNum) {
            // 将深拷贝的数据添加进result 浅拷贝会因为回溯全部变为0
            double curScore = computeCurScore();
            if (curScore > maxScore) {
                maxScore = curScore;
                bestPath = deepCopy();
            }
            return;
        }
        //index 其实也为行 从上往下判断
        for (int index = 0; index < totalCol; index++) {
            if (isValid(curRow, index)) {
                // 可以分配订单
                curPath[curRow][index] = score[curRow][index];
                backTracing(curRow+1,totalCol);
                //撤销当前的操作 因为撤销操作 所有的bestPath数组最终都变成了0回溯不可避免的事情
                curPath[curRow][index] = 0;
            }
        }
    }
    // 检查目前是否能在 row col这个位置存放数据 要求同一列只能有一个数据
    public static boolean isValid(int curRow, int curCol){
        //检查[curRow][curCol]这一列之前是否已经有数据
        for (int i = 0; i < curRow; i++) {
            if (curPath[i][curCol] != 0) {
                return false;
            }
        }
        return true;
    }
    // 计算当前分配方式下的score
    public static double computeCurScore() {
        double score = 0;
        for (int i = 0; i < orderNum; i++) {
            for (int j = 0; j < orderNum; j++) {
                score += curPath[i][j];
            }
        }
        return score;
    }
    // 深拷贝
    public static double[][] deepCopy() {
        double[][] temp = new double[orderNum][orderNum];
        for (int i = 0; i < orderNum; i++) {
            for (int j = 0; j < orderNum; j++) {
                temp[i][j] = curPath[i][j];
            }
        }
        return temp;
    }
}


