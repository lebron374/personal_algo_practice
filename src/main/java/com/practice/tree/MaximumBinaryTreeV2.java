package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/17.
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * 654. 最大二叉树
 */
public class MaximumBinaryTreeV2 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }

    /**
     *
     * @param nums
     * @param start
     * @param end （included)
     * @return
     */
    public TreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        //find max number
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i=start; i<=end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(nums[index]);
        root.left = construct(nums, start, index-1);
        root.right = construct(nums, index+1, end);

        return root;
    }
}
