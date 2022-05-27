package com.job_hunting.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * @author: cupxu
 * @create: 2022-05-03 14:23
 **/
public class LetterCombinations {
    /**
     * 设置全局列表存储最后的结果
     */
    List<String> list = new ArrayList<>();

    /**
     * 每次迭代获取一个字符串，所以会设计大量的字符串拼接，所以这里选择更为高效的 StringBuilder
     */
    StringBuilder temp = new StringBuilder();

    /**
     * 组合
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        //迭代处理
        backTracking(digits, numString, 0);
        return list;

    }

    /**
     * 比如digits如果为"23",num 为0，则str表示2对应的 abc
     * @param digits
     * @param numString
     * @param count 计数器 比较多少次
     */
    public void backTracking(String digits, String[] numString, int count) {

        // 将数字转换成字符全集 上一循环的count++后刚好等于用户输入数字的个数
        if (count == digits.length()) {
            list.add(temp.toString());
            return;
        }

        // str 表示当前num对应的字符串
        String curString = numString[digits.charAt(count) - '0'];
        for (int i = 0; i < curString.length(); i++) {
            temp.append(curString.charAt(i));
            // c
            backTracking(digits, numString, count + 1);
            // 剔除末尾的继续尝试
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
