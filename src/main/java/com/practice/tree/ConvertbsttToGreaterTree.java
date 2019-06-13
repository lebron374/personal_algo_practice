package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class ConvertbsttToGreaterTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int rightSum = 0;
    public TreeNode convertBST(TreeNode root) {

        if (null == root) {
            return root;
        }

        convertBST(root.right);

        root.val += rightSum;
        rightSum = root.val;

        convertBST(root.left);

        return root;
    }
}
