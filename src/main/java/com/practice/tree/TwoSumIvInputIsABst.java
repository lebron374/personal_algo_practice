package com.practice.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhi.wang on 2019/6/13.
 *
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/comments/
 */
public class TwoSumIvInputIsABst {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean findTarget(TreeNode root, int k) {

        inOrder(root);
        int i = 0;
        int j = list.size()-1;
        while(i < j){
            int sum = list.get(i) + list.get(j);
            if (sum == k) return true;
            if (sum > k) j--;
            else i++;
        }

        return false;
    }

    List<Integer> list = new ArrayList<Integer>();

    public void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
