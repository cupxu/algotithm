package com.jobhunting;

/**
 * @description:
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-24 21:31
 **/
import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        int ans = new Solution().binaryGap(22);
        System.out.println(ans);
    }

    public int binaryGap(int n) {

        String str = getBinaryString(n);
        System.out.println(str);

        List<Character> list = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println(list);

        int numOf1 = Collections.frequency(list, '1');
        System.out.println(numOf1);

        if(numOf1 < 2){
            return 0;
        }

        int first = str.indexOf("1");
        int last = str.lastIndexOf("1");
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

    public String getBinaryString(int n){
        int yushu = 0;
        StringBuilder sb = new StringBuilder();
        while(true){
            if(n == 1){
                sb.insert(0,1);
                return sb.toString();
            }
            // 先求余数，再求商
            yushu = n % 2;
            n = n / 2;
            sb.insert(0,yushu);
        }
    }

}
