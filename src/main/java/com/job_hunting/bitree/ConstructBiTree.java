package com.job_hunting.bitree;

/**
 * @description: 根据前序中序 或 后序中序 构造二叉树
 * @Param:
 * @return:
 * @author: cupxu
 * @create: 2022-04-27 11:35
 **/
public class ConstructBiTree {


}

/**
 * 第一步：如果数组大小为零的话，说明是空节点了。
 *
 * 第二步：如果不为空，那么取后序数组最后一个元素作为节点元素。
 *
 * 第三步：找到后序数组最后一个元素在中序数组的位置，作为切割点
 *
 * 第四步：按根节点位置 切割中序数组，切成中序左数组和中序右数组 （顺序别搞反了，一定是先切中序数组）
 *
 * 第五步：按子树大小切割 因为后续遍历 遍历左子树 再遍历右子树 最后遍历根 切割后序数组，切成后序左数组和后序右数组
 *
 * 第六步：把根节点和左右子树根节点连接 ， 递归处理左区间和右区间
 */
class PostIn {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree1(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    /**
     * 遍历序列的指针遵循 左闭右闭的原则 [a,b)
     */
    public TreeNode buildTree1(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        // 没有元素了
        if (inRight - inLeft < 0) {
            return null;
        }
        // 只有一个元素了
        if (inRight - inLeft == 0) {
            return new TreeNode(inorder[inLeft]);
        }
        // 每次创建一个节点，将节点加入到新的序列中，后序数组postorder里最后一个即为根结点
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = 0;
        // 根据根结点的值找到该值在中序数组inorder里的位置
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // 根据rootIndex划分左右子树
        root.left = buildTree1(inorder, inLeft, rootIndex - 1,
                postorder, postLeft, postLeft + (rootIndex - inLeft - 1));
        root.right = buildTree1(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight - 1);// 每次根节点已经被处理了
        return root;
    }
}


/**
 * 从前序与中序遍历序列构造二叉树
 */
class PreIn {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        if (preLength == 0 || inLength == 0) {
            return null;
        }
        return traversal(preorder, 0, preLength - 1,
                inorder, 0, inLength - 1);
    }

    public TreeNode traversal(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (preLeft > preRight) {
            return null;
        }

        // 只有一个节点，递归终止，不用在后面往这个节点添加左右子树
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        if (preLeft == preRight) {
            return root;
        }

        // 根节点在inorder中的索引
        int splitIndex;
        for (splitIndex = inLeft; splitIndex <= inRight; splitIndex++) {
            if (inorder[splitIndex] == rootVal) {
                break;
            }
        }

        // 切割中序数组
        // 中序左区间，左闭右开[leftInorderBegin, leftInorderEnd)
        int leftInorderBegin = inLeft;
        int leftInorderEnd = splitIndex - 1;
        // 中序右区间，左闭右开[rightInorderBegin, rightInorderEnd)
        int rightInorderBegin = splitIndex + 1;
        int rightInorderEnd = inRight;

        // 切割前序数组
        // 前序左区间，左闭右开[leftPreorderBegin, leftPreorderEnd)
        int leftPreorderBegin =  preLeft + 1;
        // 终止位置是起始位置加上中序左区间的大小size
        int leftPreorderEnd = preLeft + splitIndex - inLeft;
        // 前序右区间, 左闭右开[rightPreorderBegin, rightPreorderEnd)
        int rightPreorderBegin = preLeft + (splitIndex - inLeft) + 1 ;
        int rightPreorderEnd = preRight;

        root.left = traversal(preorder, leftPreorderBegin, leftPreorderEnd,
                inorder, leftInorderBegin, leftInorderEnd);
        root.right = traversal(preorder, rightPreorderBegin, rightPreorderEnd,
                inorder, rightInorderBegin, rightInorderEnd);
        return root;
    }
}