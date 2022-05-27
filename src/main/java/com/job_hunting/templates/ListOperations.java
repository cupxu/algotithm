package com.jobhunting.templates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: list操作
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-24 16:18
 **/
public class ListOperations {

        int index;
        Object obj;
        String string;
        //list 从下标0开始
        List<String> strList = new ArrayList<>();
        List<Integer> intList1 = new ArrayList<>();
        List<Integer> intList2 = new ArrayList<>();
        List<Character> charList = new ArrayList<>();

        {
                // ------------------------增---------------------------
                // 向列表的尾部添加指定的元素
                strList.add(string);
                // 在列表的指定位置插入指定元素
                strList.add(index,  string);

                // ------------------------删---------------------------
                // 移除列表中指定位置的元素，并返回被删元素
                strList.remove(index);
                // 移除集合中第一次出现的指定元素，移除成功返回true，否则返回false
                strList.remove(string);
                // 从列表中移除所有元素
                strList.clear();

                // ------------------------查---------------------------
                strList.size();
                strList.isEmpty();
                // 返回列表中指定位置的元素，index从0开始
                strList.get(index);
                // 如果列表包含指定的元素，则返回 true
                strList.contains(string);

                // ------------------------改---------------------------
                // 将索引i位置元素替换为元素element并返回被替换的元素
                strList.set(index, string);

                // ------------------------遍历---------------------------
                // 返回按适当顺序在列表的元素上进行迭代的迭代器
                strList.iterator();

                // ------------------------比较转换--------------------------

                // list -> array
                String[] strArray = strList.toArray(new String[strList.size()]);

                // array -> list 这样的list才能add remove
                String[] in = new String[]{ "1", "a"};
                // 创建列表，并指定长度，避免可能产生的扩容
                List<String> out = new ArrayList<>(in.length);
                // 实现数组添加到列表中
                Collections.addAll(out, in);

                // list 深拷贝 实现数据隔离
                List<String> toolList = new ArrayList<>(out.size());
                for (int cnt = 0; cnt < toolList.size(); cnt++) {
                    toolList.set(cnt, out.get(cnt));
                }

                // ------------------------比较--------------------------
                intList1.equals(intList2);
                // 排序后比较
                Collections.sort(intList1);
                Collections.sort(intList2);
        }

        {
               //LinkedList新增方法:必须这样创建List
                LinkedList<String> list = new LinkedList<>();
                // 将指定数据元素插入此集合的开头,原来元素（如果有）后移
                list.addFirst("str");
                // 将指定数据元素插入此集合的结尾
                list.addLast("String");
                // 移除并返回集合表的第一个数据元素
                list.removeFirst();
                // 移除并返回集合表的最后一个数据元素
                list.removeLast();
                // 返回此集合的第一个数据元素
                list.getFirst();
                // 返回此集合的最后一个数据元素
                list.getLast();
        }
}
