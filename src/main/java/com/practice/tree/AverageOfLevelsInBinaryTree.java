package com.practice.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 */
public class AverageOfLevelsInBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Float> result = new ArrayList<Float>();

    public List<Float> averageOfLevels(TreeNode root) {

        if (null == root) {
            return result;
        }

        Deque<TreeNode> nodeDeque = new ArrayDeque<TreeNode>();
        nodeDeque.add(root);

        while (!nodeDeque.isEmpty()) {
            int size = nodeDeque.size();
            int count = size;
            int sum = 0;
            while (size > 0) {
                TreeNode treeNode = nodeDeque.poll();
                sum += treeNode.val;

                if (null != treeNode.left) {
                    nodeDeque.add(treeNode.left);
                }

                if (null != treeNode.right) {
                    nodeDeque.add(treeNode.right);
                }

                size--;
            }

            result.add((float)sum/count);
        }

        return result;
    }
}
