package com.jobhunting.algotithm.order;

import java.util.ArrayList;

/**
 * @description: 二分法
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-02-20 09:38
 **/
public class BinarySearch {


    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            array.add(i);
        }
        Solution solution = new Solution();
        //int[] arr = list.stream().mapToInt(i -> i).toArray();
        int[] intArray = array.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(solution.search(intArray, 4));
    }

}
    class Solution{

        public int search(int nums[], int target) {
            // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
            if (target < nums[0] || target > nums[nums.length - 1]) {
                return -1;
            }
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    //+1减少比较操作 因为mid已经比较过了
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }
