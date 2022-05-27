package com.jobhunting.newcoder.meituan;

import java.io.*;
import java.util.*;

/**
 * @description: 用map 表示树和图
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-13 10:54
 **/
public class TreeGraphMap {

    // 定义树或者图的结构
    static class Node{
        // 节点值 可修改为其他
        int value;
        // 此节点的子节点list 是表示树和图的关键
        List<Node> sonList = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 节点总数
        int totalNodes = Integer.parseInt(br.readLine());
        // 完成树或图的结构 由于题目给出的根节点为1 所以这里要有n+1个节点 0节点不发挥其他作用
        Node[] treeOrGraph = new Node[totalNodes + 1];
        for (int i = 0; i < totalNodes+1; i++) {
            // 初始化所有节点 分配内存空间
            treeOrGraph[i] = new Node();
        }
        // 根据题目确定 bitree 或者 graph 的具体结构
        for (int i = 0; i < totalNodes-1; i++) {
            //获取节点
            String[] input = br.readLine().trim().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            // 添加 node 的子节点 sonNode
            treeOrGraph[node1].sonList.add(treeOrGraph[node2]);
            // 由于题目的输入只能确定是 无向树 或 无向图 还要把node1添加进node2的儿子中（邻接矩阵）
            treeOrGraph[node2].sonList.add(treeOrGraph[node1]);
        }
        // 对已经修改好的 无向树/无向图 进行调整
        adjust(treeOrGraph[1], treeOrGraph );
        // 根据输入填充value
        String[] colors = br.readLine().trim().split(" ");
        for (int i = 1; i < totalNodes+1; i++) {
            treeOrGraph[i].value = Integer.parseInt(colors[i - 1]);
        }
        /* 计算每个颜色的个数 先构造出一个map用于存储遍历过程中的 key颜色 value颜色值
        * 由于这里的颜色是正整数 所有可以把循环index直接add进key
        * map要用TreeMap 后面要排序
        */
        Map<Integer, Integer> countColor = new TreeMap<>();
        int selectTimes = Integer.parseInt(br.readLine().trim());
        // 每次选取都要输出一个结果
        for (int i = 0; i < selectTimes; i++) {
            int selectRoot = Integer.parseInt(br.readLine().trim());
            // 计算所有颜色对应的节点树有哪些
            computeColor(treeOrGraph[selectRoot], treeOrGraph, countColor);
            List<Integer> list = new ArrayList<>(countColor.values());
            Collections.sort(list);
            // 颜色最多的是节点
            int max = list.get(list.size() - 1);
            for (Map.Entry entry : countColor.entrySet()) {
                // 这里注意比较的是Integer 不是int
                if (entry.getValue() == Integer.valueOf(max)) {
                    System.out.println(entry.getKey());
                    break;
                }
            }
            // 一定要清空计算color的map
            countColor.clear();
        }
    }
    /**
    * @Description:  调整 无向图/无向树 使之成为有向
    * @Param: 要调节的节点node 整棵树或整张图  treeOrGraph
    * @return: 由于是对引用调节，不需要返回值，调节结果直接作用于原地址
    * @Author: xulifeng
    * @Date: 3/13/2022
    */
    public static void adjust(Node node, Node[] treeOrGraph) {
        // 取节点的子数组
        List<Node> sonList = node.sonList;
        // 递归结束条件
        if (sonList.size() == 0) {
            return;
        }
        for (Node traverseNode : sonList){
            // 取儿子的所有儿子
            List<Node> sonSonList = traverseNode.sonList;
            // remove孙子节点中
            sonSonList.remove(node);
            traverseNode.sonList = sonSonList;
             // 类似二叉树的dfs递归 三部曲
            adjust(traverseNode, treeOrGraph);
        }
    }

    public static void computeColor(Node node, Node[] treeOrGraph, Map<Integer, Integer> map) {
        int color = node.value;
        // 将已有的颜色加1 不然就赋值1 put自动覆盖相同key的元素
        map.put(color, map.getOrDefault(color, 0) + 1);
        if (node.sonList.size() == 0) {
            return;
        }
        for (Node sonNode : node.sonList) {
            computeColor(sonNode, treeOrGraph, map);
        }
    }
}














