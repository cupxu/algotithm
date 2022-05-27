package com.jobhunting.leetcode.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 找乱序匹配字符
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-25 21:11
 **/
public class MatchArrangements {

}
class Solution6 {
    public List<Integer> findAnagrams(String s, String p) {
        char[] ar = p.toCharArray();
        Arrays.sort(ar);
        String target = String.valueOf(ar);

        List<Integer> list = new LinkedList();
        int len = p.length();
        for(int i = 0;i < s.length() - len + 1;i++){
            if(isTrue(s.substring(i,i+len),target)){
                list.add(i);
            }
        }
        return list;
    }

    public boolean isTrue(String str1,String str2){

        char[] ar = str1.toCharArray();
        Arrays.sort(ar);
        String str11 = String.valueOf(ar);
        if(str11.equals(str2)){
            return true;
        }
        else {
            return false;
        }

    }
}