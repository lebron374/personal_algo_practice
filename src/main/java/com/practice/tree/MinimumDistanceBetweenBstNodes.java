package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/submissions/
 */
public class MinimumDistanceBetweenBstNodes {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;

    public int minDiffInBST(TreeNode root) {

        inorder(root);
        return min;
    }


    public void inorder(TreeNode root) {
        if (null == root) {
            return;
        }

        inorder(root.left);

        if (null != pre) {
            int temp = root.val - pre.val;
            min = Math.min(min, temp);
        }

        pre = root;

        inorder(root.right);
    }
}
