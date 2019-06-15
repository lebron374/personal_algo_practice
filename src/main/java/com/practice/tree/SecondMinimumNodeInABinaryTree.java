package com.practice.tree;

import javafx.beans.property.ReadOnlyObjectProperty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 *
 * 二叉树中第二小的节点
 */

public class SecondMinimumNodeInABinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (null == root) {
            return -1;
        }

        return findSecond(root, root.val);

    }

    public int findSecond(TreeNode root, int value) {
        if (null == root) {
            return -1;
        }

        if (root.val > value) {
            return root.val;
        }

        int left = findSecond(root.left, value);
        int right = findSecond(root.right, value);

        if (-1 != left && -1 != right) {
            return Math.min(left, right);
        }

        return Math.max(left, right);
    }



}
