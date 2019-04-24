package com.droid.java.binarytree;

import java.util.List;

public class BSTDemo {

    public static void main(String[] args) {
        // 判断一棵树是不是搜索二叉树：左子树所有节点都小于根节点，又子树所有节点都大于根节点
        System.out.println(validateBST1(initBST()));
    }

    private static TreeNode initBST() {
        TreeNode rootNode = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);

        rootNode.left = node1;
        rootNode.right = node3;

        node1.right = node2;

        return rootNode;
    }

    /**
     * 中序遍历，遍历后的结果为升序，证明该树为搜索二叉树
     *
     * @param list
     * @return
     */
    private static boolean validateBST1(TreeNode list) {
        List<Integer> result = TraversalDemo.inOrderTraversal(list);
        System.out.println(result);
        return false;
    }

    /**
     * 中序遍历，遍历过程中判断 当前节点是否大于前驱节点
     * 若大于，当前节点为前驱节点，继续遍历下一节点
     * 若不大于，则不是搜索二叉树
     *
     * @param list
     * @return
     */
    private static boolean validateBST2(TreeNode list) {

        return false;
    }

    /**
     * 递归
     * 遍历二叉树，返回值中包含节点中的最大值，最小值
     * 遍历左子树返回的最大值要小于根节点的值
     * 遍历右子树返回的最小值要大于根节点的值
     *
     * @param list
     * @return
     */
    private static boolean validateBST3(TreeNode list) {
        return false;
    }
}
