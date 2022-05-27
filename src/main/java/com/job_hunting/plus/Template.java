package com.jobhunting.plus;

import java.io.*;

/**
 * @Description: 计算并保存所有分组方式下的 score 值，取最大值 优化方向 -> 循环计算并 始终存储一组最好的值
 * @Param:
 * @return:
 * @Author: xulifeng
 * @Date: 3/10/2022
 */
public class Template {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int start = 0, end = str.lastIndexOf(str.charAt(start)), len = str.length();
        // 滑动窗口尾部比总长度小
        while (end < len) {
            // 判断在start - end 之间是否有元素的位置超过了end
            int compareIndex = start+1;
            // 比完整个窗口
            while (compareIndex < end) {
                end = Math.max(end, str.lastIndexOf(str.charAt(compareIndex)));
                compareIndex++;
            }
            // 输出这轮窗口的长度
            System.out.print(end - start + 1);
            System.out.print(" ");
            // 下一个窗口应该在end+1处
            start = end + 1;
            // 本次循环的尾部
            if (start < len) {
                end = str.lastIndexOf(str.charAt(start));
            } else {
                return;
            }
        }
    }
}


