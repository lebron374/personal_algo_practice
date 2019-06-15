package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/subtree-of-another-tree/solution/
 *
 * 572. 另一个树的子树
 */

public class SubtreeOfAnotherTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {

        if (null == s || null == t) {
            return false;
        }

        if(s.val == t.val && isSameTree(s,t)) {
            return true;
        }

        if(isSubtree(s.left,t)) {
            return true;
        }

        if(isSubtree(s.right,t)) {
            return true;
        }

        return false;
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {

        if (null == s && null == t) {
            return true;
        }

        if (null !=s && null != t && s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }

        return false;
    }

}
