package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/13.
 *
 * https://leetcode-cn.com/problems/merge-two-binary-trees
 *
 * 合并二叉树
 */
public class MergeTwoBinaryTrees {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (null == t1 ) {
            return t2;
        }

        if (null == t2) {
            return t1;
        }

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        t1.val += t2.val;

        return t1;
    }
}
