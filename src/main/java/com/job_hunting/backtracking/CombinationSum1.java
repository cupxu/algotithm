package com.job_hunting.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 组合问题 元素可重复
 * @author: cupxu
 * @create: 2022-05-04 08:15
 **/
public class CombinationSum1 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 先进行排序
        Arrays.sort(candidates);
        backtracking( candidates, target, 0, 0);
        return res;
    }

    public void optimizeBacktracking(int[] candidates, int target, int sum, int startIndex) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 如果 sum + candidates[i] > target 就终止遍历 也隐含了终止递归
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            // 不是i 是candidates[i]
            path.add(candidates[i]);
            // 进入递归前可以判断一下
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }

    public void backtracking(int[] candidates, int target, int sum, int startIndex) {
        // 不符合条件
        if (sum > target) {
            return;
        }
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            sum += candidates[i];
            path.add(i);
            backtracking(candidates, target, sum, i);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
