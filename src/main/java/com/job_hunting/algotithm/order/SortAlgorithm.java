package com.jobhunting.algotithm.order;

import java.util.Arrays;

/**
 * @description: 排序算法
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-02-23 14:57
 **/
public class SortAlgorithm {

    public static void main(String[] args) throws Exception {
        int[] test = randomCommon(-1000,1000,10);

        System.out.println("bubbleSort:");
        for (int i : bubbleSort(randomCommon(-1000,1000,10))) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("selectionSort:");
        for (int i : selectionSort(randomCommon(-1000,1000,10))) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("insertSort:");
        for (int i : insertSort(randomCommon(-1000,1000,10))) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("shellSort:");
        for (int i : shellSort(randomCommon(-1000,1000,10))) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("mergeSort:");
        for (int i : mergeSort(randomCommon(-1000,1000,10))) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("quickSort:");
        for (int i : mergeSort(randomCommon(-1000,1000,10))) {
            System.out.print(i+" ");
        }
        System.out.println();
    }

    //冒泡排序 升序 有点双指针的意思 flag优化
    public static int[] bubbleSort(int[] nums) throws Exception{
        int len = nums.length;
        //特殊情况优先考虑
        if (len < 2) {
            return nums;
        }
        //比较len-1次即可实现排序
        for (int i = 0; i < len - 1; i++) {
            //默认是有序的
            boolean flag = true;
            //单次遍历 每次从第一个遍历 每次遍历的次数 -1 比较的是两个j和j后一个元素
            for (int j = 0; j < len - i -1; j++) {
                //异或交换两个元素
                if (nums[j] > nums[j + 1]) {
                    nums[j + 1] = nums[j + 1] ^ nums[j];
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j + 1] ^ nums[j];
                    flag = false;
                }
            }
            if (flag) {
                return nums;
            }
        }
        return nums;
    }

    //选择排序 升序
    public static int[] selectionSort(int[] nums) throws Exception{
        //特殊情况优先考虑
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        //一共比较N-1次 最后剩下的不用比较
        int min;
        for (int i = 0; i < nums.length - 1; i++) {
            //单次循环找到最小值索引
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            //如果最小值不是i 将最小值挪到单次循环开始
            if (min != i) {
                nums[i] ^= nums[min];
                nums[min] ^= nums[i];
                nums[i] ^= nums[min];
            }
        }
        return nums;
    }

    //插入排序 升序 可优化为二分插入 减少元素比较的次数
    public static int[] insertSort(int[] nums) throws Exception {
        //特殊情况优先考虑
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            //记录要插入到
            int current = nums[i];
            //j作为比较索引表示target最终要存放的位置
            int pre = i - 1;
            while (nums[pre] > current && pre >= 0) {
                //移动左侧有序数据
                nums[pre + 1] = nums[pre];
                pre--;
            }
            //最后一次比较后要么是pre这个位置小于current 要么是pre < 0
            nums[pre + 1] = current;
        }
        return nums;

    }

    //shell排序
    public static int[] shellSort(int[] nums) throws Exception {
        //特殊情况优先考虑
        if (nums.length == 0 || nums.length == 1) {
            return nums;
        }
        //单组插入排序从索引值为步长时进行比较，步长为1时也留下了索引为0处的元素
        for (int step = nums.length / 2; step > 0; step /= 2) {
            for (int i = step; i < nums.length; i++) {
                int current = nums[i];
                //j代表当前组 target前一个待比较元素
                int pre = i - step;
                while (pre >= 0 && nums[pre] > current) {
                    //移动元素
                    nums[pre + step] = nums[pre];
                    //递归元素
                    pre -= step;
                }
                //发现在j处已经<current 那么在pre+step处放置current
                nums[pre+step] = current;

            }
        }
        return nums;
    }

    //归并排序
    public static int[] mergeSort(int[] nums) throws Exception {
        //递归退出的条件
        if (nums.length < 2) {
            return nums;
        }

        int middle = (int) Math.floor(nums.length / 2);
        //从左索引 右索引为（位置加1）
        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle, nums.length);
        return merge(mergeSort(left), mergeSort(right));

    }
    public static int[] merge(int[] left, int[] right) {
        //result为排序后数组
        int[] result = new int[left.length + right.length];
        int index = 0;
        int i = 0, j = 0;
        //当两子数组均存在数据时
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                //更新子数组的元素
                result[index++] = left[i++];
            } else {
                //更新子数组的元素
                result[index++] = right[j++];
            }
        }
        //复制余下一组数组到新数组 余下的i 或 j刚好指向未排序的那个 之后index会超出
        while (i < left.length) {
            result[index++] = left[i++];
        }
        //复制余下一组数组到新数组
        while (j < right.length) {
            result[index++] = right[j++];
        }
        return result;
    }

    //k快排
    public static int[] quickSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        return quickSort(nums);
    }

    //单组排序 将大的移到右边 将小的移到左边
    public static int[] sort(int[] nums){
        int len = nums.length;
        if (len < 2) {
            return nums;
        }
        //左右指针
        int leftIndex = 1, rightIndex = nums.length - 1;
        //较标准
        int pivot = 0;
        //开始比较交换 退出条件是leftIndex rightIndex
        while (leftIndex <= rightIndex) {
            if (nums[rightIndex] <= pivot) {
                swap(nums[pivot], nums[rightIndex]);
                //交换后右指针左移一位
                rightIndex--;
            }
            if (nums[leftIndex] >= nums[pivot]) {
                swap(nums[pivot], nums[leftIndex]);
                //交换后左指针加一位
                leftIndex++;
            }
        }
        return nums;
    }

    public static void swap(int a, int b) {
        a ^= b;
        b ^= a;
        a ^= b;
    }






















    //数组测试工具类
    public static int[] randomCommon(int min, int max, int n){
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while(count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(num == result[j]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result[count] = num;
                count++;
            }
        }
        return result;
    }
}
