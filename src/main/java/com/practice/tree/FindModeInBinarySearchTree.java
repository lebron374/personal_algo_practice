package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 *
 * 501. 二叉搜索树中的众数
 */

public class FindModeInBinarySearchTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<Integer> list = new ArrayList<Integer>();
    TreeNode pre;
    int max = 0;
    int cur = 1;


    public int[] findMode(TreeNode root) {

        if(root==null) {
            return new int[] {};
        }

        inOrder(root);

        int[] a = new int[list.size()];
        for(int i=0;i<list.size();i++) {
            a[i]=list.get(i);
        }

        return a;

    }

    /**
     * 中序遍历相等的肯定就挨着
     */
    public void inOrder(TreeNode root) {

        if (null == root) {
            return;
        }

        // 先遍历左子树
        inOrder(root.left);

        // 对比当前值和之前的值
        if (null != pre) {
            if (pre.val == root.val) {
                cur += 1;
            } else {
                cur = 1;
            }
        }

        if (max == cur) {
            list.add(root.val);
        }

        if (cur > max) {
            list.clear();
            list.add(root.val);
            max = cur;
        }

        pre = root;

        // 再遍历右子树
        inOrder(root.right);

    }
}
