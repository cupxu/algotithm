package com.job_hunting.bitree;

import java.util.*;

/**
 * @description: 根据输入序列构造二叉树
 * @Param:
 * @return:
 * @author: xulifeng
 * @create: 2022-03-14 19:10
 **/
public class GenerateBinaryTree {

    /**
    * @Description: 根据题目数组序列 初始化对应的节点 并将节点存进list 之后通过父节点与左右子节点的关系梳理二叉树
    * @Param: 节点数组 arr
    * @return: 根节点 root
    * @Author: xulifeng
    * @Date: 3/14/2022
    */
    static TreeNode generate(int[] arr) {
        int len = arr.length;
        List<TreeNode> list = new ArrayList<>(len);
        // 初始化根节点为null
        TreeNode root = null;
        for (int i = 0; i < len; i++) {
            TreeNode node = null;
            // 这里用-1表示空节点 也可替换为null
            if (arr[i] != -1) {
                // node初始化后放进list中 list存放的就是整棵树
                node = new TreeNode(arr[i]);
            }
            // 添加空节点
            list.add(node);
            // 根节点
            if (i == 0) {
                root = node;
            }
        }

        // 最后一个节点一定为 i*2+2
        for (int i = 0; i*2+2 < len; i++) {
            // 遍历所有节点 空节点不作为父节点 可作为子节点
            if (list.get(i) != null) {
                list.get(i).left = list.get(2 * i + 1);
                list.get(i).right = list.get(2 * i + 2);
            }
        }
        return root;
    }

    /**
     * @Description: 借助队列实现层序遍历 将结果存放到list中
     * @Param: 树根节点 root
     * @return:
     * @Author: xulifeng
     * @Date: 3/14/2022
     */
    //QueueTraverse--迭代方式--借助队列
    static List<List<Integer>> traverse(TreeNode node) {
        List<List<Integer>> resList = new ArrayList<>();
        if (node == null) {
            return null;
        }
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        que.offer(node);

        while (!que.isEmpty()) {
            //对每一层的分别建立一个list存放本层数据
            List<Integer> subList = new ArrayList<>();
            //len获取到的是每层一开始的数据大小
            int len = que.size();

            while (len > 0) {
                //取出本层节点并删除
                TreeNode tmpNode = que.poll();
                subList.add(tmpNode.val);

                if (tmpNode.left != null) {
                    que.offer(tmpNode.left);
                }
                if (tmpNode.right != null) {
                    que.offer(tmpNode.right);
                }
                len--;
            }
            //一层的数据遍历添加完毕 开始下一层
            resList.add(subList);
        }
        return resList;
    }

    // 测试
    public static void main(String[] args) {
        int[] arr = {4,1,6,0,2,5,7,-1,-1,-1,3,-1,-1,-1,8};
        TreeNode root = generate(arr);
        List<List<Integer>> resList = traverse(root);
        System.out.println(resList);
    }


}
