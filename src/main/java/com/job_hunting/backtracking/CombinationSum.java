package com.job_hunting.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 找出所有相加之和为 n 的 k 个数的组合
 * @author: cupxu
 * @create: 2022-05-03 08:22
 **/
public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * @param targetSum 目标和
     * @param k 元素个数
     * @param sum path元素和
     * @param startIndex 添加元素索引
     */
    void backtracking(int targetSum, int k, int sum, int startIndex){
        // 剪枝操作
        if (sum > targetSum) {
            return;
        }
        // 满足条件 加入result
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            // 不等也要return
            return;
        }
        // 也有剪枝优化 循环的条件
        for (int i = startIndex; i <= 9-(k-path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(targetSum, k, sum, i + 1);
            sum -= i;
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(n, k, 0, 1);
        return result;
    }

}
