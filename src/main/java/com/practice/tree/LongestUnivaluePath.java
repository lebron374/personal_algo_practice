package com.practice.tree;

public class LongestUnivaluePath {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int longest = 0;

    public int longestUnivaluePath(TreeNode root) {

        if (null == root) {
            return longest;
        }

        int temp = dfsV1(root);

        if (temp > longest) {
            longest = temp;
        }

        if (null != root.left) {
            longestUnivaluePath(root.left);
        }

        if (null != root.right) {
            longestUnivaluePath(root.right);
        }

        return longest;
    }

    public int dfsV1(TreeNode root) {

        int temp = 0;

        if (null != root.left && root.val == root.left.val) {
            temp += dfs(root.left, 1);
        }

        if (null != root.right && root.val == root.right.val) {
            temp += dfs(root.right, 1);
        }

        return temp;
    }

    public int dfs(TreeNode root, int sum) {

        if (null == root) {
            return sum;
        }

        if (null != root.left && null != root.right && root.left.val == root.val && root.right.val == root.val) {

            return Math.max(dfs(root.left, sum+1), dfs(root.right, sum+1));
        }


        if (null != root.left && root.left.val == root.val) {
            return dfs(root.left, sum+1);
        }

        if (null != root.right && root.right.val == root.val) {
            return dfs(root.right, sum+1);
        }

        return sum;
    }
}
