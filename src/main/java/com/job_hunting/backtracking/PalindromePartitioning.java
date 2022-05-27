package com.job_hunting.backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 分割回文串
 * @author: cupxu
 * @create: 2022-05-05 08:03
 **/
public class PalindromePartitioning {

    List<List<String>> result = new ArrayList<>();
    ArrayDeque<String> path = new ArrayDeque<>();


    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String str, int startIndex) {
        if (startIndex >= str.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 起始位置是startIndex
        for (int i = startIndex; i < str.length(); i++) {
            // 如果是回文子串 不是的话继续加1
            if (isPalindrome(str,startIndex,i)){
                String string = str.substring(startIndex, i + 1);
                path.add(string);
            } else{
                continue;
            }
            backtracking(str, i + 1);
            path.removeLast();
        }
    }

    /**
     * 回文串判断 不通过直接算str 而是算原str的下标
     */
    public boolean isPalindrome(String str,int left,int right) {
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
