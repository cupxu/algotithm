package com.jobhunting.newcoder.meituan;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 入队出队序列
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-04-08 09:05
 **/
public class PushPopSeq {

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        //int[] popped = {4,5,3,2,1};
        int[] popped = {4,3,5,1,2};
        System.out.println(Solution.validateStackSequences(pushed, popped));
    }
    static class Solution {
        public static boolean validateStackSequences(int[] pushed, int[] popped) {
            int len = pushed.length;
            List<Integer> list = new LinkedList<>();
            // pop元素对应的push顺序
            for (int i = 0; i < len - 1; i++) {
                list.clear();
                int flag = getIndex(pushed, popped[i]);
                for (int j = i+1; j < len; j++) {
                    // 如果poped在pop[i]之前入队 将pop[i]对应元素
                    if (getIndex(pushed, popped[j]) < flag) {
                        list.add(popped[j]);
                    }
                }
                // 判断list中的元素的出栈顺序是否逆序
                for (int j = 0; j < list.size() - 1; j++) {
                    int prev = getIndex(pushed,list.get(j));
                    int next = getIndex(pushed,list.get(j+1));
                    if (prev < next ){
                        return false;
                    }
                }
            }
            return true;
        }
    }

    static int getIndex(int[] src, int target) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] == target) {
                return i;
            }
        }
        return -1;
    }


}
