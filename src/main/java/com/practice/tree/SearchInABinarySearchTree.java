package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInABinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode searchBST(TreeNode root, int val) {

        if (null == root) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
