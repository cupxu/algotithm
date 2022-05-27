package com.job_hunting.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 回溯经典问题-组合问题
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
 * @author: cupxu
 * @create: 2022-05-02 10:06
 **/
public class Combinations {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        // 从1开始，不是从0开始
        optimizedBacktracking(n,k,1);
        return result;
    }
    /**
     * 回溯算法 剪枝
     * @param n
     * @param k
     * @param startIndex for循环指针
     */
    public void optimizedBacktracking(int n, int k,int startIndex) {
        // 终止条件：path中有k个元素
        if (path.size() == k) {
            // 拷贝后再添加
            result.add(new ArrayList<>(path));
            return;
        }
        // 如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了
        // 已经选择的元素个数：path.size();
        // 还需要的元素个数为: k - path.size();
        // 在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历
        // 如果没有path 那么for循环 区间一开始是从 [1,n - k + 1]
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            // 处理节点
            path.add(i);
            // backtracking(n,k,startIndex+1)不是startIndex+1 是 i+1
            // 递归：控制树的纵向遍历，注意下一层搜索要从i+1开始，相当于把后一个元素移动到path当中
            backtracking(n,k,i+1);
            // 回溯，撤销处理的节点
            path.removeLast();
        }
    }
    /**
     * 回溯算法
     * @param n
     * @param k
     * @param startIndex for循环指针
     */
    public void backtracking(int n, int k,int startIndex) {
        // 终止条件：path中有k个元素
        if (path.size() == k) {
            // 拷贝后再添加
            result.add(new ArrayList<>(path));
            return;
        }
        // 控制树的横向遍历
        for (int i = startIndex; i <= n; i++) {
            // 处理节点
            path.add(i);
            // backtracking(n,k,startIndex+1)不是startIndex+1 是 i+1
            // 递归：控制树的纵向遍历，注意下一层搜索要从i+1开始
            backtracking(n,k,i+1);
            // 回溯，撤销处理的节点
            path.removeLast();
        }
    }
}
