package com.job_hunting.bitree;

import java.util.ArrayDeque;

/**
 * @description: 求深度
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-28 15:40
 **/
public class GetDepth {

    /**
     * 递归法 三部曲
     * 1. 确定递归函数返回值、函数名、参数列表
     * 2. 确定终止条件 空节点
     * 3. 单层递归逻辑
     */
    public int getDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        // 左子树 右子树高度
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        // 高度 +1
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 层次遍历，获取最大深度
     */
    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                // visit
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return depth;
    }

    /**
     * 层次遍历，获取最小深度
     */
    public int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                // visit
                TreeNode temp = queue.poll();
                // 满足最小深度条件
                if (temp.left != null && temp.right != null) {
                    return depth;
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return depth;
    }




}
