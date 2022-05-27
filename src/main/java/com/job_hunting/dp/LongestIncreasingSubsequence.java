package com.job_hunting.dp;

import java.util.Arrays;

/**
 * @description: 最长递增子序列 dp[i]由哪些状态可以推出来，并取最大值
 * @author: cupxu
 * @create: 2022-05-14 08:22
 **/
public class LongestIncreasingSubsequence {
    /**
     * 错误解法
     */
    public int lengthOfLISFalse(int[] nums) {

        int[] dp = new int[nums.length];
        // 初始化
        dp[0] = 1;

        for (int i = 1; i < nums.length; i++) {
                // 大于前一个不一定大于前一个的前面的数据
                if (nums[i] > nums[i-1]) {
                    dp[i] = dp[i-1] + 1;
                }else{
                    dp[i] = dp[i-1];
                }
        }
        return dp[nums.length - 1];
    }

    /**
     * 正解
     */
    public int lengthOfLIS(int[] nums) {
        // 以i为结尾子序列的元素个数
        int[] dp = new int[nums.length];
        //
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(dp[i], result);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
