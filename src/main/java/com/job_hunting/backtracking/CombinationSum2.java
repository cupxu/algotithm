package com.job_hunting.backtracking;

import java.util.*;

/**
 * @description: 组合 candidates 中的每个数字在每个组合中只能使用 一次
 * @author: cupxu
 * @create: 2022-05-04 15:15
 **/
public class CombinationSum2 {
    List<List<Integer>> result = new ArrayList<>();
    ArrayDeque<Integer> path = new ArrayDeque<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        // 加标志数组，用来辅助判断同层节点是否已经遍历
        boolean[] flag = new boolean[candidates.length];
        backTracking(candidates, target, 0, flag);
        return result;
    }

    public void backTracking(int[] arr, int target, int index, boolean[] flag) {
        if (sum == target) {
            result.add(new ArrayList(path));
            return;
        }
        for (int i = index; i < arr.length && arr[i] + sum <= target; i++) {

            // 同一层数值相同的结点第 2、3 ... 个结点，因为数值相同的第 1 个结点已经搜索出了包含了这个数值的全部结果
            if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum += arr[i];
            path.offer(arr[i]);
            // 每个节点仅能选择一次，所以从下一位开始
            backTracking(arr, target, i + 1, flag);
            int temp = path.pollLast();
            flag[i] = false;
            sum -= temp;
        }
    }
}
