package com.job_hunting.bitree;

/**
 * @description: 平衡二叉树
 * @author: cupxu
 * @create: 2022-04-29 08:19
 **/
public class BalancedBiTree {

    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
        //return getHeight(root) == -1 ? false : true;
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }
        return Math.abs(leftHeight - rightHeight) > 1 ? -1 : 1 + Math.max(leftHeight, rightHeight);

    }


}
