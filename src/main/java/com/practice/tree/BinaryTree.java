package com.practice.tree;

/**
 * Created by lebron374 on 2019/6/12.
 */
public class BinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    private int value = 0;

    public int findTilt(TreeNode root) {

        transfer(root);

        return value;
    }

    private int transfer(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int left = transfer(root.left);
        int right = transfer(root.right);
        value += Math.abs(left - right);

        return left + right + root.val;
    }
}
