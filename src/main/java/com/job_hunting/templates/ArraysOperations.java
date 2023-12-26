package com.jobhunting.templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @description: 数组操作
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-24 18:32
 **/
public class ArraysOperations {
    
    int[] array,array1,array2;
    int val = 1;
    int from,to;

    {
        Arrays.toString(array);
        // array到list Collections
        Arrays.asList(array);
        // 升序排列数组
        Arrays.sort(array);
        // 二分查找
        Arrays.binarySearch(array, 3);
        // 指定数组填充
        Arrays.fill(array, val);
        // [from,to)
        Arrays.copyOfRange(array,from,to);
        // @Return boolean
        Arrays.equals(array1,array2);

        // array -> list 这样的list才能add remove
        String[] in = new String[]{ "1", "a"};
        // 创建列表，并指定长度，避免可能产生的扩容
        List<String> list = new ArrayList<>(Arrays.asList(in));
    }

}
