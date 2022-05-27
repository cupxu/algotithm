package com.jobhunting.companies.meituan;

import java.io.*;
import java.util.*;
/**
* @Description: 计算并保存所有分组方式下的 score 值，取最大值 优化方向 -> 循环计算并 始终存储一组最好的值
* @Param:
* @return:
* @Author: xulifeng
* @Date: 3/10/2022
*/
public class MeituanCar {
    // 存放所有可能的结果
    static List<double[][]> result = new ArrayList<>();
    //存放对应分配方式下的总分
    static List<Double> tempScoreList = new ArrayList<>();
    //原始分配表
    static double[][] score;
    //单次分配结果
    static double[][] path;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //
        score = new double[n][n];
        //单次分配路径
        path = new double[n][n];
        // 填充score 和 path
        for (int i = 0; i < n; i++) {
            String[] oneRowScore = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                score[i][j] = Double.parseDouble(oneRowScore[j]);
                path[i][j] = 0;
            }
        }
        //从第0行开始递归
        backTracing(0, n);
        //获取最大值及其对应的下标
        double maxScore = Collections.max(tempScoreList).doubleValue();
        int position = tempScoreList.indexOf(maxScore);
        double[][] targetArr = result.get(position);

        System.out.printf("%.2f",maxScore);
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (targetArr[i][j] != 0) {
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
        if (curRow == totalCol) {
            // 将深拷贝的数据添加进result 浅拷贝会因为回溯全部变为0
            result.add(deepCopy(totalCol));
            tempScoreList.add(computeScore(path));
            return;
        }
        for (int col = 0; col < totalCol; col++) {
            if (isValid(curRow, col, path)) {
                path[curRow][col] = score[curRow][col];
                backTracing(curRow+1,totalCol);
                //撤销当前的操作 因为撤销操作 所有的path数组最终都变成了0回溯不可避免的事情
                path[curRow][col] = 0;
            }
        }
    }
    // 检查目前是否能在 row col这个位置存放数据 要求同一列只能有一个数据
    public static boolean isValid(int curRow, int curCol, double[][] currentState){
        //检查[curRow][curCol]这一列之前是否已经有数据
        for (int i = 0; i < curRow; i++) {
            if (currentState[i][curCol] != 0) {
                return false;
            }
        }
        return true;
    }
    // 计算当前分配方式下的score
    public static double computeScore(double[][] path) {
        double score = 0;
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                score += path[i][j];
            }
        }
        return score;
    }
    // 深拷贝
    public static double[][] deepCopy(int totalCol) {
        double[][] temp = new double[totalCol][totalCol];
        for (int i = 0; i < totalCol; i++) {
            for (int j = 0; j < totalCol; j++) {
                temp[i][j] = path[i][j];
            }
        }
        return temp;
    }
}


