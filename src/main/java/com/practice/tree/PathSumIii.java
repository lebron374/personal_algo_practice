package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/14.
 * https://leetcode-cn.com/problems/path-sum-iii/comments/
 */
public class PathSumIii {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {

        // 以根节点，根左子节点，根右子节点 作为起始节点的数量之和
        return getPathSum(root, sum) + getPathSum(root.left, sum) + getPathSum(root.right, sum);
    }

    public int getPathSum(TreeNode root, int sum) {
        if (null == root) {
            return 0;
        }

        if (sum == root.val) {
            return 1;
        }

        return getPathSum(root.left, sum - root.val) + getPathSum(root.right, sum - root.val);
    }

}
