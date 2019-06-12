package com.practice.tree;

/**
 * Created by lebron374 on 2019/6/12.
 */
public class UnivalTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (null == root) {
            return true;
        }

        return isSameValue(root, root.val);
    }

    public boolean isSameValue(TreeNode root, int parentValue) {
        if (null == root) {
            return true;
        }

        if (parentValue != root.val) {
            return false;
        }

        boolean bLeft = isSameValue(root.left, parentValue);
        boolean bRight = isSameValue(root.right, parentValue);

        return bLeft && bRight;
    }
}
