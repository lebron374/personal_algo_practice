package com.practice.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/cousins-in-binary-tree/submissions/
 *
 * 二叉树的堂兄弟节点
 */
public class CousinsInBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<Integer, Integer> levelMap = new HashMap<Integer, Integer>();
    Map<Integer, TreeNode> parentMap = new HashMap<Integer, TreeNode>();

    public boolean isCousins(TreeNode root, int x, int y) {
        findTreeNode(root, null, x,0);
        findTreeNode(root, null, y,0);

        if (null != levelMap.get(x) && !levelMap.get(x).equals(levelMap.get(y))) {
            return false;
        }

        if (null != parentMap.get(x) && parentMap.get(x).val == parentMap.get(y).val) {
            return false;
        }

        return true;
    }

    public void findTreeNode(TreeNode root, TreeNode parent, int x, int level) {
        if (null == root) {
            return;
        }

        if (null != parent) {
            if (x == root.val) {
                levelMap.put(x, level);
                parentMap.put(x, parent);
            }
        }

        findTreeNode(root.left, root, x, level+1);
        findTreeNode(root.right, root, x, level+1);
    }
}
