package com.job_hunting.string;

/**
 * @description: KMP算法
 * @author: cupxu
 * @create: 2022-04-23 16:20
 **/
public class KMP {


    /**
     * 字符串前缀表中的元素，是这个串最大相等前后缀中元素的个数，是一个整数
     * @param 
     * @return
     */
    public static void getNext(int[] next, String p) {
        // 只有一个元素时没有前缀表，前缀长度为0 可看做递归初始化
        next[0] = 0;
        // 前缀串的尾元素指针,子串s[0]-s[j]以s[j]结尾 同时代表子串s[0]-s[i]的 最长相等前后缀元素 的个数
        int j = 0;
        // i是后缀串的尾元素指针，子串s[0]-s[i]所有的后缀都以s[i]结尾
        for (int i = 1; i < p.length(); i++) {
            // j要保证大于0，因为下面有取j-1作为数组下标的操作
            while (j > 0 && p.charAt(j) != p.charAt(i)) {
                // 前缀回退 j刚好是next[j-1]最大相等前后缀的个数，刚好是下一个比较位置的索引
                j = next[j - 1];
            }
            if (p.charAt(j) == p.charAt(i)){
                j++;
            }
            // 子串s[0]-s[i]的最长相等前后缀元素个数为j
            next[i] = j;
        }
    }

    /**
     * 匹配
     */
    public static int strStr(String s, String p) {
        // 模式串为空
        if (p.length() == 0) {
            return 0;
        }
        int[] next = new int[p.length()];
        getNext(next, p);

        // 模式串比较指针
        int j = 0;
        // 主串比较指针，从第一个元素开始比较
        for (int i = 0; i < s.length(); i++) {
            while(j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == p.length()) {
                return (i - p.length() + 1);
            }
        }
        // 匹配失败
        return -1;
    }

}

