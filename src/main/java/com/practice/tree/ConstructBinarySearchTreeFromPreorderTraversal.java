package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/17.
 * https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * 1008. 先序遍历构造二叉树
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode rawRoot = new TreeNode(0xffffff);

        for (int val : preorder) {
            buildTree(rawRoot, val);
        }

        return rawRoot.left;
    }

    public void buildTree(TreeNode root, int val) {

        // 往左构造子树
        if (root.val > val) {
            if (null == root.left) {
                root.left = new TreeNode(val);
            } else {
                buildTree(root.left, val);
            }
        }

        // 往右构造子树
        if (root.val < val) {
            if (null == root.right) {
                root.right = new TreeNode(val);
            } else {
                buildTree(root.right, val);
            }
        }
    }
}
