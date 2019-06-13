package com.practice.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Deque<Node> nodeDeque = new LinkedList<Node>();

    public List<List<Integer>> levelOrder(Node root) {

        if (null == root) {
            return result;
        }

        nodeDeque.add(root);

        while (!nodeDeque.isEmpty()) {
            List<Integer> nodes = new ArrayList<Integer>();

            int size = nodeDeque.size();
            while (size > 0) {

                Node node = nodeDeque.poll();
                nodes.add(node.val);

                for (Node child : node.children){
                    nodeDeque.add(child);
                }

                size--;
            }

            result.add(nodes);
        }

        return result;
    }
}
