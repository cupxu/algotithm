package com.job_hunting.bitree;

/**
 * @description: 搜索二叉树
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-27 20:31
 **/
public class BST {
     // 查找
     public TreeNode searchBST(TreeNode root, int key){
         // 递归三部曲
         if (root == null || root.val == key) {
             return root;
         }
         // 搜索到目标节点了，就要立即return了
         // 这样才是找到节点就返回（搜索某一条边），如果不加return，就是遍历整棵树了
         if (key < root.val) {
             return searchBST(root.left, key);
         }
         else {
             return searchBST(root.right, key);
         }
     }
     // 插入
     public TreeNode insertIntoBST(TreeNode root, int val) {
         // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
         if (root == null) {
             // 把添加的节点返回给上一层，就完成了父子节点的赋值操作
             return new TreeNode(val);
         }

         if (root.val < val){
             // 递归创建右子树
             root.right = insertIntoBST(root.right, val);
         }else if (root.val > val){
             // 递归创建左子树
             root.left = insertIntoBST(root.left, val);
         }
         return root;
     }
}
