package com.jobhunting.algotithm.dataStructure;

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
// 节点
class LNode {
    int val;
    LNode next;
    LNode(){}
    LNode(int val) {
        this.val=val;
    }
}

// 单链表
class LinkList {
    //size存储链表元素的个数
    int size;
    //虚拟头结点
    LNode head;

    //初始化链表
    public LinkList() {
        size = 0;
        head = new LNode(0);
    }

    // i从下标为1开始
    public LNode getNode(int i) {
        int count = 0;
        LNode target = head;
        while (count < i){
            target = target.next;
        }
        return target;
    }
    //获取第index个节点的数值
    public int get(int index) {
        //如果index非法，返回-1
        if (index < 0 || index >= size) {
            return -1;
        }
        LNode currentNode = head;
        //包含一个虚拟头节点，所以查找第 index+1 个节点
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    //在链表最前面插入一个节点
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    //在链表的最后插入一个节点
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
    // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
    // 如果 index 大于链表的长度，则返回空
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        LNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        LNode toAdd = new LNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }

    //删除第index个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        LNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
}

// 双链表
class DLinkList {
    class LNode {
        int val;
        LNode next,prev;
        LNode(int x) {val = x;}
    }

    int size;
    LNode head,tail;//Sentinel node

    /** Initialize your data structure here. */
    public DLinkList() {
        size = 0;
        head = new LNode(0);
        tail = new LNode(0);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size){return -1;}
        LNode cur = head;

        // 通过判断 index < (size - 1) / 2 来决定是从头结点还是尾节点遍历，提高效率
        if(index < (size - 1) / 2){
            for(int i = 0; i <= index; i++){
                cur = cur.next;
            }
        }else{
            cur = tail;
            for(int i = 0; i <= size - index - 1; i++){
                cur = cur.prev;
            }
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        LNode cur = head;
        LNode newNode = new LNode(val);
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
        newNode.prev = cur;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        LNode cur = tail;
        LNode newNode = new LNode(val);
        newNode.next = tail;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size){return;}
        if(index < 0){index = 0;}
        LNode cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        LNode newNode = new LNode(val);
        newNode.next = cur.next;
        cur.next.prev = newNode;
        newNode.prev = cur;
        cur.next = newNode;
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size || index < 0){return;}
        LNode cur = head;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }
}

// 自定义链表操作
public class MyLinkedList {
    public static void main(String[] args) {
        LinkList L = new LinkList();
        for (int i = 1; i <= 6; i++) {
            L.addAtTail(i);
            System.out.println(L.get(i - 1));
        }
        LNode ans = new LNode();
        reverse(ans,L.getNode(1),L.getNode(1));
        for (int i = 1; i <= 6; i++) {
            System.out.println(L.get(i - 1));
        }
    }


    public static void reverse(LNode target,LNode pre, LNode p){
        if (p.next != null) {
            reverse(target,pre.next,p.next);
        }
        if (p.next == null) {
            target = p;
        }
        p.next = pre;
        System.out.println(p.val);
    }
}

