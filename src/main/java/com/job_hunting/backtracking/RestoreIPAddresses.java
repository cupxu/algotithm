package com.job_hunting.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 复原IP地址
 * @author: cupxu
 * @create: 2022-05-05 13:56
 **/
public class RestoreIPAddresses {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 算是剪枝了
        if (s.length() > 12) {
            return result;
        }
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return result;
    }

    /**
     * @param sb
     * @param startIndex
     * @param pointCount
     */
    public void backtracking(StringBuilder sb,int startIndex, int pointCount) {
        // 终止条件
        if (pointCount >= 3) {
            // 判断第四段⼦字符串是否合法，如果合法就放进result中
            if (isValid(sb,startIndex,sb.length()-1)) {
                result.add(sb.toString());
            }
            return;
        }

        for (int i = startIndex; i < sb.length(); i++) {
            // 对.分割的ip段进行逐个校验
            if (isValid(sb, startIndex, i)) {
                // 在str的后⾯插⼊⼀个逗点
                sb.insert(i+1, '.');
                pointCount++;
                // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                backtracking(sb, i + 2, pointCount);
                pointCount--;// 回溯
                // 回溯删掉逗点 保证了i的范围不变
                sb.deleteCharAt(i + 1);
            } else {
                break;
            }
        }
    }

    /**
     * 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
     */
    private Boolean isValid(StringBuilder s, int start, int end) {
        // 判断.最后是否还有字符
        if (start > end) {
            return false;
        }
        // 0开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            // 如果⼤于255了不合法
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
}
