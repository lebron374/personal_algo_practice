package com.practice.tree;

public class SumOfRootToLeafBinaryNumbers {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);

        return sum;
    }


    public void dfs(TreeNode node, int val) {

        if (node == null) {
            return;
        }

        int newVal = val<<1 | node.val;

        if (node.left == null && node.right == null){
            sum += newVal ;
        }else{
            dfs(node.left,newVal);
            dfs(node.right,newVal);
        }
    }

}
