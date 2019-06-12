package com.practice.tree;

import java.util.*;

/**
 * Created by zhi.wang on 2019/6/11.
 */
public class TreeProgram {

    class TreeNode<T> {
        T data;
        TreeNode leftChild;
        TreeNode rightChild;
    }

    /**
     * 构造基础树，用于其他方法验证结果
     *
     *        5
     *      3   7
     *     2 4 6 8
     *
     * @return
     */
    public TreeNode constructBasicTree() {

        // 根节点
        TreeNode<Integer> root = new TreeNode<Integer>();
        root.data = 5;

        // 根节点左右子树
        TreeNode<Integer> rootLeftChild = new TreeNode<Integer>();
        TreeNode<Integer> rootRightChild = new TreeNode<Integer>();
        rootLeftChild.data = 3;
        rootRightChild.data = 7;
        root.leftChild = rootLeftChild;
        root.rightChild = rootRightChild;

        // 根节点左子树的左右子树
        TreeNode<Integer> rootLeftLeftChild = new TreeNode<Integer>();
        TreeNode<Integer> rootLeftRightChild = new TreeNode<Integer>();
        rootLeftLeftChild.data = 2;
        rootLeftRightChild.data = 4;
        rootLeftChild.leftChild = rootLeftLeftChild;
        rootLeftChild.rightChild = rootLeftRightChild;

        // 根节点右子树的左右子树
        TreeNode<Integer> rootRightLeftChild = new TreeNode<Integer>();
        TreeNode<Integer> rootRightRightChild = new TreeNode<Integer>();
        rootRightLeftChild.data = 6;
        rootRightRightChild.data = 8;
        rootRightChild.leftChild = rootRightLeftChild;
        rootRightChild.rightChild = rootRightRightChild;

        return root;
    }

    /**
     * 递归实现先序遍历
     * @param root
     */
    public void preOrderTransfer(TreeNode<Integer> root) {
        if (null == root) {
            return;
        }

        System.out.println(root.data);

        preOrderTransfer(root.leftChild);
        preOrderTransfer(root.rightChild);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void inOrderTransfer(TreeNode<Integer> root) {
        if (null == root) {
            return;
        }

        inOrderTransfer(root.leftChild);

        System.out.println(root.data);

        inOrderTransfer(root.rightChild);
    }

    /**
     * 后序遍历
     * @param root
     */
    public void postOrderTransfer(TreeNode<Integer> root) {
        if (null == root) {
            return;
        }

        postOrderTransfer(root.leftChild);
        postOrderTransfer(root.rightChild);

        System.out.println(root.data);
    }

    /**
     * 层次遍历
     * @param root
     */
    public void levelTransfer(TreeNode<Integer> root) {

        if (null == root) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode<Integer> treeNode = queue.poll();

            System.out.println(treeNode.data);

            if (null != treeNode.leftChild) {
                queue.add(treeNode.leftChild);
            }

            if (null != treeNode.rightChild) {
                queue.add(treeNode.rightChild);
            }
        }
    }

    /**
     * 打印指定层次的树
     * @param root
     * @param height
     */
    public void levelInnerTransfer(TreeNode<Integer> root, int height) {

        if (null == root) {
            return;
        }

        if (0 == height) {
            System.out.println(root.data);
        }

        levelInnerTransfer(root.leftChild, height - 1);
        levelInnerTransfer(root.rightChild, height - 1);
    }

    public void levelInnerTransferV2(TreeNode<Integer> root, int height) {

        if (null == root) {
            return;
        }

        if (0 == height) {
            System.out.print(root.data);
        }

        levelInnerTransfer(root.leftChild, height - 1);
        levelInnerTransfer(root.rightChild, height - 1);
    }

    /**
     * 层次遍历，用非队列方式
     * @param root
     */
    public void levelTransferV2(TreeNode<Integer> root) {
        int height = getTreeHeight(root);

        for (int i=0; i<height+1; i++) {
            levelInnerTransfer(root, i);
        }
    }

    /**
     * 按照树形进行打印
     * @param root
     */
    public void levelTreePrint(TreeNode<Integer> root) {
        int height = getTreeHeight(root);
        for (int i=0; i<height+1; i++) {
            levelInnerTransferV2(root, i);
            System.out.print("\r\n---------------\r\n");
        }
    }

    /**
     * 获取树的深度，我们认为根节点的深度为0
     * @param root
     * @return
     */
    public int getTreeHeight(TreeNode<Integer> root) {
        if (null == root.leftChild && null == root.rightChild) {
            return 0;
        }

        int leftTreeHeight = getTreeHeight(root.leftChild);
        int rightTreeHeight = getTreeHeight(root.rightChild);

        return 1 + (leftTreeHeight > rightTreeHeight ? leftTreeHeight:rightTreeHeight);
    }

    /**
     * 查找子节点的公共父节点
     * @param root
     * @return
     */
    public TreeNode<Integer> findCommonParent(TreeNode<Integer> root, Integer node1, Integer node2) {

        // root==null说明已经遍历到叶子节点的子节点了
        // 其他两种情况说明找到root节点等于待查找的节点
        if (null == root || root.data.equals(node1) || root.data.equals(node2)) {
            return root;
        }

        // 从底层慢慢查找然后网上回溯就行
        TreeNode<Integer> left = findCommonParent(root.leftChild, node1, node2);
        TreeNode<Integer> right = findCommonParent(root.rightChild, node1, node2);

        // 如果当前节点的左右子树都包含节点的一部分，说明当前节点就是父节点
        if (null != left && null != right) {
            return root;
        }

        if (null != left) {
            return left;
        }

        if (null != right) {
            return right;
        }

        return null;
    }

    /**
     * 查找子节点的公共父节点，通过找到完整的可达链路
     * @param root
     * @return
     */
    public void findCommonParentV2(TreeNode<Integer> root, Integer node1, Integer node2) {
        Deque<Integer> nodeQueue1 = new ArrayDeque<Integer>();
        Deque<Integer> nodeQueue2 = new ArrayDeque<Integer>();

        boolean bRet1 = findTreeNodeV2(root, node1, nodeQueue1);
        boolean bRet2 = findTreeNodeV2(root, node2, nodeQueue2);

        Integer common = 0;
        if (bRet1 && bRet2) {
            while (!nodeQueue1.isEmpty() && !nodeQueue2.isEmpty() && nodeQueue1.peek().equals(nodeQueue2.peek())) {
                common = nodeQueue1.peek();
                nodeQueue1.poll();
                nodeQueue2.poll();
            }

            System.out.println(common);
        }
    }

    public boolean findTreeNodeV2(TreeNode<Integer> root, Integer node, Deque<Integer> queue) {

        // 找到null的节点依然没有找到就返回错误
        if (null == root) {
            return false;
        }

        // 把当前节点加入访问路径当中
        queue.add(root.data);

        // 找到就直接返回成功
        if (root.data.equals(node)) {

            return true;
        }

        // 没有找到就先查找左子树，后查找右子树
        boolean bRet = findTreeNodeV2(root.leftChild, node, queue);

        if (!bRet) {
            bRet = findTreeNodeV2(root.rightChild, node, queue);
        }

        // 如果左右子树都没有查到就把当前节点剔除
        if (!bRet) {
            queue.pollLast();
        }

        return bRet;
    }

    private TreeNode<Integer> pHead = null;
    private TreeNode<Integer> pTail = null;

    public void treeToList(TreeNode<Integer> root) {

        if (null == root) {
            return;
        }

        // 先遍历左子树
        treeToList(root.leftChild);

        // 处理中间节点
        if (null == pHead) {
            pHead = root;
        }

        if (null == pTail) {
            pTail = root;
        }else {
            pTail.rightChild = root;
            root.leftChild = pTail;
            pTail = root;
        }

        // 最后遍历右子树
        treeToList(root.rightChild);
    }

    public static void main(String[] args) {

        TreeProgram treeProgram = new TreeProgram();
        TreeNode<Integer> root = treeProgram.constructBasicTree();

        System.out.println("preOrderTransfer");
        treeProgram.preOrderTransfer(root);

        System.out.println("inOrderTransfer");
        treeProgram.inOrderTransfer(root);

        System.out.println("postOrderTransfer");
        treeProgram.postOrderTransfer(root);

        System.out.println("levelTransfer");
        treeProgram.levelTransfer(root);

        System.out.println("levelTransferV2");
        treeProgram.levelTransferV2(root);

        System.out.println("levelTreePrint");
        treeProgram.levelTreePrint(root);

        System.out.println("findCommonParentV2");
        treeProgram.findCommonParentV2(root, 6, 8);

        System.out.println("findCommonParent");
        treeProgram.findCommonParentV2(root, 6, 8);

        System.out.println("treeToList");
        treeProgram.treeToList(root);

        System.out.println(treeProgram.pHead.data);
    }
}
