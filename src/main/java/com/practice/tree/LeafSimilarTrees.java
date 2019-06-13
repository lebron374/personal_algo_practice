package com.practice.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leaf1 = new ArrayList<Integer>();
        List<Integer> leaf2 = new ArrayList<Integer>();

        findLeaf(root1, leaf1);
        findLeaf(root2, leaf2);

        if (leaf1.size() != leaf2.size()) {
            return false;
        }

        for (int i=0; i< leaf1.size(); i++) {
            if (leaf1.get(i) != leaf2.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void findLeaf(TreeNode root, List<Integer> list) {

        if (null == root) {
            return;
        }

        if (null == root.left && null == root.right) {
            list.add(root.val);

            return;
        }

        findLeaf(root.left, list);
        findLeaf(root.right, list);
    }
}
