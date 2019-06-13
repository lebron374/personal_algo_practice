package com.practice.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class NAryTreePostorderTraversal {

    class Node {
        public int val;

        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    List<Integer> list = new ArrayList<Integer>();

    public List<Integer> postorder(Node root) {

        if (null == root) {
            return list;
        }

        List<Node> children = root.children;

        for (Node node:children) {

            postorder(node);
        }

        list.add(root.val);

        return list;
    }
}
