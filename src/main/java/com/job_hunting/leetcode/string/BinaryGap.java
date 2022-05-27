package com.jobhunting.leetcode.string;

/**
 * @description: 二进制间距
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-25 14:25
 **/
public class BinaryGap {

}

class Solution {


    public int binaryGap(int n) {

        String str = Integer.toBinaryString(n);

        int first = str.indexOf("1");
        int last = str.lastIndexOf("1");
        if(first == last || first == -1){
            return 0;
        }
        int now = first,next;
        int distance = 0;
        while(true){
            if(now == last){
                return distance;
            }
            next = str.indexOf("1",now+1);
            distance = distance > next-now ? distance : next-now;
            now = next;
        }
    }

}
// 868. 二进制间距
class Solution1 {
    public int binaryGap(int n) {
        int last = -1, ans = 0;
        for (int i = 0; n != 0; ++i) {
            // 如果最后一位为1
            if ((n & 1) == 1) {
                // 如果有上一位的话
                if (last != -1) {
                    ans = Math.max(ans, i - last);
                }
                last = i;
            }
            // 右移一位
            n >>>= 1;
        }
        return ans;
    }
}

