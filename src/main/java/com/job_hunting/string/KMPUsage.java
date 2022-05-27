package com.job_hunting.string;

/**
 * @description: 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-24 09:53
 **/
public class KMPUsage {

    /**
     * 1.s一定有最大相等前后缀 即 next[s.length - 1] != 0
     * 2.s元素个数减去前缀长度后仍能被s整除
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        if(len == 0){
            return false;
        }
        int[] next = new int[len];
        KMP.getNext(next,s);
        if(next[len-1] != 0 && len % (len - next[len-1]) == 0){
            return true;
        }
        return false;
    }

}
