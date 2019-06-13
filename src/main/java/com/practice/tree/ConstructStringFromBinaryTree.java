package com.practice.tree;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
public class ConstructStringFromBinaryTree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    StringBuilder stringBuilder = new StringBuilder();

    public String tree2str(TreeNode t) {

        if (null == t) {
            return stringBuilder.toString();
        }

        // 处理当前节点，如果是第一个节点就不用左括号"("
        if (stringBuilder.toString().length() == 0) {
            stringBuilder.append(t.val);
        } else {
            stringBuilder.append("(");
            stringBuilder.append(t.val);
        }

        if (null != t.left) {
            tree2str(t.left);
            stringBuilder.append(")");
        } else if (null != t.right) {
            stringBuilder.append("()");
        }

        if (null != t.right) {
            tree2str(t.right);
            stringBuilder.append(")");
        }

        return stringBuilder.toString();
    }
}
