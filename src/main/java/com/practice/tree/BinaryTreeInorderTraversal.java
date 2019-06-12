package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lebron374 on 2019/6/12.
 */
public class BinaryTreeInorderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> tempList = new ArrayList<Integer>();

        if (null == root) {
            return tempList;
        }

        List<Integer> leftList = inorderTraversal(root.left);
        tempList.addAll(leftList);
        tempList.add(root.val);
        List<Integer> rightList = inorderTraversal(root.right);
        tempList.addAll(rightList);

        return tempList;
    }
}
