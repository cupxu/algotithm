package com.jobhunting.templates;

/**
 * @description: 集合工具类使用
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-08 14:17
 **/
public class MyCollections {

    public static void main(String[] args) {
    /*
        //list 从下标0开始
        List<String> strList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        strList.size()
        strList.add(Object element) 向列表的尾部添加指定的元素
        strList.add(int index, Object element) 在列表的指定位置插入指定元素
        strList.remove(int index) 移除列表中指定位置的元素，并返回被删元素
        strList.remove(Object o) 移除集合中第一次出现的指定元素，移除成功返回true，否则返回false
        strList.get(int index) 返回列表中指定位置的元素，index从0开始
        strList.set(int i, Object element) 将索引i位置元素替换为元素element并返回被替换的元素
        strList.clear() 从列表中移除所有元素
        strList.isEmpty() 判断列表是否包含元素，不包含元素则返回 true，否则返回false
        strList.iterator() 返回按适当顺序在列表的元素上进行迭代的迭代器
        strList.contains(Object o) 如果列表包含指定的元素，则返回 true

        LinkedList新增方法:必须这样创建List
        LinkedList<String> list = new LinkedList<>();
        void addFirst(Object o) 将指定数据元素插入此集合的开头,原来元素（如果有）后移
        void addLast(Object o) 将指定数据元素插入此集合的结尾
        Object removeFirst() 移除并返回集合表的第一个数据元素
        Object removeLast() 移除并返回集合表的最后一个数据元素
        Object getFirst() 返回此集合的第一个数据元素
        Object getLast() 返回此集合的最后一个数据元素

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

        Collections.sort(list());//对list升序排列
        Collections.shuffle(list);//随机排序
        Collections.binarySearch(list,object);
        Collections.reverse(list);//反转
        Collections.rotate(list,distance);//循环右移distance
        Collections.copy(dest,src);//把src中元素复制到dest中，同时覆盖索引
        Collections.swap(list,i,j);//交换ij元素
        Collections.fill(list,obj);//填充
        Collections.max(coll);//自然比较
        Collections.min(coll);
        int indexOf(Object o)
        int lastIndexOf(Object o)
        Collections.indexOfSubList(srcList,targetList);
        Collections.lastIndexOfSubList(srcList,targetList);
        Collections.replaceAll(List,oldObject, newObject);//若要替换的值存在刚返回true
        Collections.frequency(coll,obj);//返回指定元素出现的次数
    */

    }

}
