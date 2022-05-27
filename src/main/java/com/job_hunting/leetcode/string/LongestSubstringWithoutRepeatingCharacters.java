package com.job_hunting.leetcode.string;

import java.util.HashSet;

/**
 * @description: 无重复字符的最长子串
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-26 15:15
 **/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        // s长度
        int len = s.length();
        // 结果
        int ans = 0;
        // 右指针 一开始为负
        int leftIndex = 0;
        char temp;
        while (leftIndex < len) {
            for (int i = leftIndex; i < len; i++) {
                temp = s.charAt(i);
                if (!set.contains(temp)) {
                    set.add(temp);
                }else {
                    break;
                }
            }
            // 保留最大值
            //ans = ans > set.size() ? ans : set.size();
            ans = Math.max(set.size(), ans);
            // 清空set
            set.clear();
            ++leftIndex;
        }
        return ans;
    }
}

