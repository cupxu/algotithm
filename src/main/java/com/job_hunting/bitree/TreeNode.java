package com.job_hunting.bitree;

import java.util.*;

/**
 * @description: 链式存储
 * @author: cupxu
 * @create: 2022-02-24 14:43
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}


/**
 * 前序遍历·递归·LC144_二叉树的前序遍历
 */
class PreOrderDFS {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    // 把存储遍历结果的list作为参数便于递归 如果在单层遍历内部new list 不利于存放递归节点
    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            //遍历整棵树 不用返回任何值 但是要做循环终止处理
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}

/**
 * 中序遍历·递归·LC94_二叉树的中序遍历
 */
class InOrderDFS {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            // visit
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}

/**
 * 后序遍历·递归·LC145_二叉树的后序遍历
  */
class PostOrderDFS {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    void postorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postorder(root.left, list);
        postorder(root.right, list);
        list.add(root.val);             // 注意这一句
    }

}

