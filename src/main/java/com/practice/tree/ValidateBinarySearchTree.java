package com.practice.tree;

/**
 * Created by lebron374 on 2019/6/12.
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    double last = - Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {

        if (null == root) {
            return true;
        }

        if (isValidBST(root.left)) {

            if (last < root.val) {

                last = root.val;

                return isValidBST(root.right);
            }
        }

        return false;

    }
}
