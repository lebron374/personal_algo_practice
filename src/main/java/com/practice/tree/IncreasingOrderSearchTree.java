package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
public class IncreasingOrderSearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    TreeNode pHead = null;
    TreeNode pTail = null;
    public TreeNode increasingBST(TreeNode root) {

        if (null == root) {
            return root;
        }

        increasingBST(root.left);

        if (null == pHead) {
            pHead = root;
        }

        if (null == pTail) {
            pTail = root;
            pTail.left = null;
        } else {
            pTail.right = root;
            root.left = null;
            pTail = root;
        }

        increasingBST(root.right);

        return pHead;
    }
}
