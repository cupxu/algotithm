package com.jobhunting.leetcode.string;

/**
 * @description: 回文子串个数
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-25 20:52
 **/
public class PalindromicSubstrings {

}

class Solution4 {
    // 判断所有可能的子串
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;
        for(int i = 0;i<len;i++){
            for(int j = i;j<len;j++){
                if(isTrue(s,i,j)){
                    ++ans;
                }
            }
        }
        return ans;

    }

    // 判断子串是否回文
    public boolean isTrue(String s, int start, int end){
        int left = start;
        int right = end;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}