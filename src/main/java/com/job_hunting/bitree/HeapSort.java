package com.job_hunting.bitree;

import java.util.Arrays;

/**
 * @description: 大根堆
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-08 15:11
 **/
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};
        // 数据隔离
        int[] arr = Arrays.copyOf(array, array.length);

        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        // 1.从最后一个叶子节点的父节点开始构建大根堆 最后一个节点的位置为 arr.length - 1 其父节点为 arr.length - 2
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 2，调整堆的结构 + 交换堆顶与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr,0,i);
            adjustHeap(arr,0,i - 1);
        }
    }

    // 找到dad左右子节点的最大值 同时把原来dad指向的节点值放在合适的位置
    public static void adjustHeap(int[] arr, int curDad, int len) {
        int temp = arr[curDad];
        for (int son = 2*curDad + 1; son < len; son = 2*son + 1) {
            // 从左右子节点中选出最大的
            if (son+1 < len && arr[son] < arr[son + 1]) {
                son++;//指向右子节点
            }
            // 根据大根堆性质 不用管和哪个子节点比较 需要的只是放置temp的位置
            if (temp < arr[son]){
                arr[curDad] = arr[son];
                curDad = son;
            } else {
                break;
            }
        }
        // 将temp放到最终位置
        arr[curDad] = temp;
    }
    
    public static void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

