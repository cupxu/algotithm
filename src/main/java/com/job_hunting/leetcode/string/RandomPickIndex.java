package com.jobhunting.leetcode.string;

import java.util.*;

/**
 * @description: 水塘抽样
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-25 17:02
 **/
// 398. 随机数索引
public class RandomPickIndex {

}
class Solution2 {
    int[] nums;
    Random random;

    public Solution2(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /**
     * 遍历过程中利用随机数保持概率相等
     * @param target
     * @return
     */
    public int pick(int target) {
        int ans = 0;
        for (int i = 0, cnt = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++cnt; // 第 cnt 次遇到 target
                if (random.nextInt(cnt) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }
}

class Solution3 {
    /**
     * 哈希表方式
     */
    Map<Integer, List<Integer>> pos;
    Random random;

    public Solution3(int[] nums) {
        pos = new HashMap<Integer, List<Integer>>();
        random = new Random();
        for (int i = 0; i < nums.length; ++i) {
            // 存在以nums[i]为键的元素，那么
            pos.putIfAbsent(nums[i], new ArrayList<Integer>());
            // 获取到list后添加这个下标
            pos.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = pos.get(target);
        // 随机返回一个索引
        return indices.get(random.nextInt(indices.size()));
    }
}
