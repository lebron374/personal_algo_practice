package com.practice.tree;

import java.util.List;

/**
 * Created by zhi.wang on 2019/6/13.
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaximumDepthOfNAryTree {


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }

        int max = 0;

        for (Node child : root.children) {
            int depth = maxDepth(child);
            if (max < depth) {
                max = depth;
            }
        }

        return 1+ max;
    }
}
