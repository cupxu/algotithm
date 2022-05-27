package com.job_hunting.bitree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 遍历
 * @author: cupxu
 * @create: 2022-04-29 09:55
 **/

class StackTraverse {
    /**
     * 前序 深度相关
     */
    public List<Integer> preOrder(TreeNode root) {
        TreeNode p = root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        // 存放结果 visit操作
        List<Integer> result = new ArrayList<>();
        // p不空，或者栈不空，表示要进行入栈或出栈操作，两个都空表示结束
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                // visit p
                result.add(p.val);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        return result;
    }

    /**
     * 中序 顺序相关
     */
    public List<Integer> inOrder(TreeNode root) {
        TreeNode p = root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        // 存放结果 visit操作
        List<Integer> result = new ArrayList<>();
        // p不空，或者栈不空，表示要进行入栈或出栈操作，两个都空表示结束
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                // visit p
                result.add(p.val);
                p = p.right;
            }
        }
        return result;
    }

    /**
     * 后序遍历 高度相关
     */
    public List<Integer> postOrder(TreeNode root) {
        TreeNode p = root;
        // 每个点都可能有一个右孩子，在访问这个点之前要保证访问过它的左右孩子
        TreeNode r = null;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        // 存放结果 visit操作
        List<Integer> result = new ArrayList<>();

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                // 走到树的最左边
                p = p.left;
            } else {
                // 读栈顶指针，这里是乐观思路
                p = stack.peek();
                // 若右子树存在且未被访问
                if (p.right != null && p.right != r) {
                    p = p.right;
                } else {
                    // 处理节点
                    p = stack.pop();
                    // visit
                    result.add(p.val);
                    // 更新被访问点
                    r = p;
                    // 重置p指针，从栈中获取
                    p = null;
                }
            }
        }
        return result;
    }



}

/**
 * 二叉树的层序遍历
 */
class QueueTraverse {
    /**
     * 存放一层一层的数据
     */
    public List<List<Integer>> resList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        traverse(root, resList);
        return resList;

    }

    /**
     *  树的孩子节点可能有不止两个
     */
    public void traverse(TreeNode node, List<List<Integer>> resList) {
        // 判空
        if (node == null) {
            return;
        }
        // 准备
        ArrayDeque<TreeNode> que = new ArrayDeque<>();
        TreeNode cur;
        // 循环开始
        que.offer(node);
        while (!que.isEmpty()) {
            //len获取到的是每层一开始的数据大小
            int len = que.size();
            //对每一层的分别建立一个list存放本层数据
            List<Integer> subList = new ArrayList<Integer>(len);

            while (len > 0) {
                //取出本层节点并删除
                cur = que.poll();
                len--;
                // visit
                subList.add(cur.val);

                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
            }
            //一层的数据遍历添加完毕 开始下一层
            resList.add(subList);
        }
    }

    /**
     * 单纯遍历所有元素
     */
    public void visit(TreeNode root) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode p = root,temp = null;
        queue.offer(p);
        while (!queue.isEmpty()) {
            // visit 节点
            temp = queue.poll();
            System.out.println(temp.val);
            if (p.left != null) {
                queue.offer(temp.left);
            }
            if (p.right != null) {
                queue.offer(temp.right);
            }
        }
    }
}
