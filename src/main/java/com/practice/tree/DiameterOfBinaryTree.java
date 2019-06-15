package com.practice.tree;


/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * 二叉树的直径
 */

public class DiameterOfBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if (null == root) {
            return 0;
        }

        treeHeight(root);

        return res;
    }

    public int treeHeight(TreeNode root) {

        if (null == root) {
            return 0;
        }

        // 计算左子树的高度
        int left = treeHeight(root.left);
        // 计算右子树的高度
        int right = treeHeight(root.right);
        // 计算以root为节点直径,相当于不同的root
        res = Math.max(res, left + right);
        // 返回以root的节点的深度
        return Math.max(left, right) + 1;
    }
}
