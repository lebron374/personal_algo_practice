package com.practice.tree;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
public class TrimABinarySearchTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (null == root) {
            return root;
        }

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }
}
