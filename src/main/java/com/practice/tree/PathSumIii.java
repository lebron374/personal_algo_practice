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

    int num = 0;
    public int pathSum(TreeNode root, int sum) {

        if (null == root) {
            return 0;
        }

        // 以根节点计算数量
        getPathSum(root, sum);

        // 遍历左子树
        pathSum(root.left, sum);

        // 遍历右子树
        pathSum(root.right, sum);

        return num;
    }

    public void getPathSum(TreeNode root, int sum) {
        if (null == root) {
            return;
        }

        if (sum == root.val) {
            num += 1;
        }

        getPathSum(root.left, sum - root.val);

        getPathSum(root.right, sum - root.val);
    }

}
