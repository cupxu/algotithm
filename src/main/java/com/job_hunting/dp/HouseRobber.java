package com.job_hunting.dp;

/**
 * @description: 打家劫舍
 * @author: cupxu
 * @create: 2022-05-11 08:51
 **/
public class HouseRobber {
    /**
     * 房屋线性排列 不考虑收尾相邻
     * @param nums
     * @return
     */
    public int robI(int[] nums) {
        // 全是空房间
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // 1 确定dp数组及下标含义
        int[] dp = new int[nums.length];
        // 3 初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        // 2 确定dp数组的递推公式 dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);

        // 4 确定遍历顺序 从第3个元素 索引为2 开始
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        // 5返回值
        return dp[nums.length - 1];
    }

    /**
     * 房屋呈环状排列 考虑首尾相邻
     * @param nums
     * @return
     */
    public static int robII(int[] nums) {
        // 全是空房间
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 大于等于3个才能进入这一循环
        int excludeLast = robHelper(nums, 0, nums.length - 2);
        int excludeFirst = robHelper(nums, 1, nums.length - 1);
        return Math.max(excludeFirst, excludeLast);
    }

    /**
     * 通过指针在原数组上操作，不要截取数组作为新数组
     */
    public static int robHelper(int[] nums, int start, int end) {
        // 新区间内只有2个数
        if (start + 1 == end) {
            return Math.max(nums[start], nums[start + 1]);
        }
        // 1 确定dp数组及下标含义
        int[] dp = new int[nums.length - 1];
        // 3 初始化
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start+1], dp[0]);
        // 2 确定dp数组的递推公式 dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        int dpIndex = 2;
        // 4 确定遍历顺序 从第3个元素 索引为2 开始
        for (int i = start+2; i <= end; i++,dpIndex++) {
            dp[dpIndex] = Math.max(dp[dpIndex-1], dp[dpIndex-2] + nums[i]);
        }
        // 5返回值
        return dp[nums.length - 2];
    }

    /**
     * dp 数组的长度 和 nums数组一致，便不会出现下标越界问题 最后去dp[end]即可
     */
    int robRange(int[] nums, int start, int end) {
        if (end == start) {
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,1};
        robII(test);
    }
}
