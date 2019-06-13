package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/12.
 */




public class MaximumBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {

        int index = findMaxIndex(nums, 0, nums.length);

        TreeNode treeNode = new TreeNode(nums[index]);

        if (1 == nums.length) {
            return treeNode;
        }

        treeNode.left = constructMaximumBinaryTree(nums, 0, index);
        treeNode.right = constructMaximumBinaryTree(nums, index+1, nums.length);

        return treeNode;
    }

    // end not included
    public static int findMaxIndex(int[] nums, int start, int end) {
        int max = -1;
        int index = -1;
        for (int i = start; i<end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        return index;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {

        if (start == end) {
            return null;
        }

        int index = findMaxIndex(nums, start, end);
        TreeNode treeNode = new TreeNode(nums[index]);

        if (start + 1 == end) {
            return treeNode;
        }

        treeNode.left = constructMaximumBinaryTree(nums, start, index);
        treeNode.right = constructMaximumBinaryTree(nums, index+1, end);

        return treeNode;
    }

    public static void main(String[] args) {

        int[] array = new int[] {3,2,1,6,0,5};

        TreeNode  treeNode = constructMaximumBinaryTree(array);
        System.out.println();
    }
}
