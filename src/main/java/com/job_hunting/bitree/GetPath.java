package com.job_hunting.bitree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 获取路径
 * @author: cupxu
 * @create: 2022-04-29 08:52
 **/
public class GetPath {

    public List<String> biTreePaths(TreeNode root) {
        // 有点类似 c语言的指针，直接传递地址
        List<String> result = new ArrayList<String>();
        if (root == null) {
            return result;
        }
        // 同样传递地址
        List<Integer> path = new ArrayList<Integer>();
        traverse(root, path, result);
        return result;
    }
    public void traverse(TreeNode cur, List<Integer> path, List<String> result){
        // 默认不是空节点 visit
        path.add(cur.val);
        // 终止条件
        if (cur.left == null && cur.right == null) {
            StringBuilder sb = new StringBuilder();
            // 将路径上的所有节点变成要求的path格式
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            // 收集本叶节点路径
            result.add(sb.toString());
            return;
        }
        if (cur.left != null) {
            traverse(cur.left,path,result);
            // 回溯
            path.remove(path.size() - 1);
        }
        if (cur.right != null) {
            traverse(cur.right, path, result);
            // 回溯
            path.remove(path.size() - 1);
        }

    }
}
