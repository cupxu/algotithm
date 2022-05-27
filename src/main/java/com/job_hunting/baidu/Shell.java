package com.job_hunting.baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: N枚炮弹发射
 * @author: cupxu
 * @create: 2022-04-29 14:47
 **/
public class Shell {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //读取屏幕一行输入
        int N = Integer.parseInt(br.readLine());
        String first = br.readLine().replace(" ","");
        String last = br.readLine().replace(" ","");
        System.out.println(getTimes(N, first, last));
    }

    /**
     * 炮弹发射下标范围[0,N-1]，在 x 下标发射后， 下一次只能在 [x-1,N-1]位置发射
     * 每枚炮弹较上次发射位置可提前一位发射 -> 建模成元素移动问题
     */
    public static int getTimes(int size, String firstSeq, String lastSeq) {
        if (firstSeq.equals(lastSeq)) {
            return 1;
        }
        else{
            // 移动次数
            int res = 0;
            // 找元素在两个序列中的位置
            for (int i = 0; i < size; i++) {
                int index = firstSeq.indexOf(lastSeq.charAt(i));
                if (index > i){
                    // 需要移动多少次才能到指定位置
                    res = Math.max(index - i, res);
                }
            }
            return res + 1;
        }
    }

}
