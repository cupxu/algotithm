package com.job_hunting.algotithm.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * void backtracking(参数) {
 *     if (终止条件) {
 *         存放结果;
 *         return;
 *     }
 *
 *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
 *         处理节点;
 *         backtracking(路径，选择列表); // 递归
 *         回溯，撤销处理结果
 *     }
 * }
*/
/**
 * @description: 组合问题1
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-09 08:49
 **/
public class Combine {

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        oneCombine(n, k, 1);
        return result;
    }

    public void oneCombine(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            //找到满足条件的结果
            return;
        }

        /**
         * @description: 组合问题1
         * 循环的终止条件没有必要 i <= k
         * 如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了
         * 递归时会考虑后面所有的元素 n-(k-path.size())+1 只能搜索到这儿便不能再继续搜索
         *
         * i为本次搜索的起始位置
         * 为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
         *
         * 举个例子，n = 4，k = 3， 目前已经选取的元素为1（path.size为1），n - (k - 1) + 1 即 4 - ( 3 - 1) + 1 = 3。
         *
         * 从2开始搜索都是合理的，可以是组合[2, 3, 4]。
         **/
        for (int i = startIndex; i <= n-(k-path.size())+1; i++) {
            path.add(i);
            oneCombine(n, k, i + 1);
            path.removeLast();
        }
    }





}
