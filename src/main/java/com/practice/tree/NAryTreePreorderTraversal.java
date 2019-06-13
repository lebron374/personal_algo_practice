package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class NAryTreePreorderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {

        if (null == root) {
            return result;
        }

        result.add(root.val);

        for (Node child:root.children) {
            preorder(child);
        }

        return result;
    }
}
