package com.practice.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by lebron374 on 2019/6/12.
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/submissions/
 */
public class BinaryTreeLevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (null == root) {
            return new ArrayList<List<Integer>>();
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (size>0) {

                TreeNode curNode = queue.poll();
                list.add(curNode.val);

                if (null != curNode.left) {
                    queue.add(curNode.left);
                }

                if (null != curNode.right) {
                    queue.add(curNode.right);
                }

                size--;
            }

            result.add(list);
        }

        return result;
    }
}
