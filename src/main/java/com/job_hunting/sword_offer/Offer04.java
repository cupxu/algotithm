package com.job_hunting.sword_offer;

/**
 * @description: 特征是有序 二分法
 * @author: cupxu
 * @create: 2022-05-23 09:00
 **/
public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) {
                i--;
            } else if(matrix[i][j] < target) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

}
