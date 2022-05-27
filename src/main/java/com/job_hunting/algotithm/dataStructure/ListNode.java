package com.job_hunting.algotithm.dataStructure;

/**
 * @description: 链表相关
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-02-24 16:20
 **/
public class ListNode {
    // 结点的值
    int val;
    // 下一个结点
    ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
//自定义链表类实现增删查改
class LinkedList {
    //size存储链表元素的个数
    int size;
    //虚拟头结点
    ListNode head;

    //初始化链表
    public LinkedList() {
        size = 0;
        head = new ListNode(0);
    }
    public LinkedList(int val,ListNode head) {
        size = val;
        this.head = head;
    }
}