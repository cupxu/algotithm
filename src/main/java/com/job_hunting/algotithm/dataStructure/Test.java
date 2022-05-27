package com.jobhunting.algotithm.dataStructure;

/**
 * @description: 递归测试
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-04-04 16:46
 **/

public class Test {
    class LNode {
        // 结点的值
        int data;
        // 下一个结点
        LNode next;
        // 节点的构造函数(无参)
        public LNode() {
        }
        // 节点的构造函数(有一个参数)
        public LNode(int data) {
            this.data = data;
        }
        // 节点的构造函数(有两个参数)
        public LNode(int data, LNode next) {
            this.data = data;
            this.next = next;
        }
    }

    //自定义链表类实现增删查改
    class LinkedList {
        //size存储链表元素的个数
        int size;
        //虚拟头结点
        LNode head;

        //初始化链表
        public LinkedList() {
            size = 0;
            head = new LNode(0);
        }
        public LinkedList(int val,LNode head) {
            size = val;
            this.head = head;
        }
    }

    public static void main(String[] args) {

    }

}
