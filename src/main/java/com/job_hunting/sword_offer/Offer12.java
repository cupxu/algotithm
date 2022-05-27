package com.job_hunting.sword_offer;

import java.util.Arrays;

/**
 * @description:
 * @author: cupxu
 * @create: 2022-05-23 20:38
 **/
public class Offer12 {

    public boolean exist(char[][] board, String word) {
        // 创建一个记录已访问标志
        int[][] record = new int[board.length][board[0].length];
        Arrays.fill(record, 0);
        // 开始遍历
        for (int i = 0; i < board.length; i++) {

        }
        return false;
    }

    /**
     * 判断这个这个位置能不能放
     */
    public boolean feasible(int i, int j, char[][] board, int[][] record, int target) {
        // 超出矩阵下标限制
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0) {
            return false;
        }
        // 已经访问过
        if (record[i][j] == 1) {
            return false;
        }
        if (board[i][j] != target) {
            return false;
        }
        return true;
    }
}
