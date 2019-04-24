package com.droid.java.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class TraversalDemo {
  public static void main(String args[]) {
    // 二叉树遍历
//    traversal(initTree1());

    // 计算所有左子节点个数
//    System.out.println(countOfLeftLeaves(initTree2()));

    // 计算所有左子节点数值之和
//    System.out.println(sumOfLeftLeaves(initTree2()));

    // 计算所有左子叶子节点数值之和
//    System.out.println(sumOfLeftSubLeaves(initTree2()));
  }

  /**
   * 初始化二叉树，用于下面的遍历方法
   *
   *  1
   *    2
   *  3
   *
   * @return
   */
  private static TreeNode initTree1() {
    TreeNode rootNode = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(3);

    rootNode.right = node1;
    node1.left = node2;

    return rootNode;
  }

  /**
   * 初始化二叉树，用来计算所有左子节点个数，所有左子节点数值之和
   *
   *         1
   *     2       3
   *   4   5
   *
   * @return
   */
  private static TreeNode initTree2() {
    TreeNode rootNode = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(4);
    TreeNode node4 = new TreeNode(5);

    rootNode.left = node1;
    rootNode.right = node2;
    node1.left = node3;
    node1.right = node4;

    return rootNode;
  }

  /**
   * 计算所有左子节点个数
   *
   * @param rootNode
   * @return
   */
  private static int countOfLeftLeaves(TreeNode rootNode) {
    int count = 0;
    if (rootNode == null) {
      return count;
    }

    if (rootNode.left != null) {
      count ++;
      count += countOfLeftLeaves(rootNode.left);
    }

    if (rootNode.right != null) {
      count += countOfLeftLeaves(rootNode.right);
    }

    return count;
  }

  /**
   * 计算所有左子节点数值之和
   *
   * @param rootNode
   * @return
   */
  private static int sumOfLeftLeaves(TreeNode rootNode) {
    int sum = 0;
    if (null == rootNode) {
      return sum;
    }

    if (rootNode.left != null) {
      sum += rootNode.left.val;
      sum += sumOfLeftLeaves(rootNode.left);
    }

    if (rootNode.right != null) {
      sum += sumOfLeftLeaves(rootNode.right);
    }

    return sum;
  }

  /**
   * 计算所有左子叶子节点数值之和
   *
   *         1
   *     2       3
   *   4   5
   *
   * @param root
   * @return
   */
  private static int sumOfLeftSubLeaves(TreeNode root) {
    int sum = 0;
    if (root == null) return sum;

    System.out.println("root val: " + root.val);

    if (root.left != null && root.left.left == null && root.left.right == null) {
      sum += root.left.val;
    }

    sum += sumOfLeftSubLeaves(root.left);
    sum += sumOfLeftSubLeaves(root.right);

    return sum;
  }

  /**
   * 二叉树遍历
   * 前序
   * 中序
   * 后序
   *
   * @param rootNode
   */
  private static void traversal(TreeNode rootNode) {
    System.out.println(preOrderTraversal(rootNode));

    System.out.println(inOrderTraversal(rootNode));

    System.out.println(postOrderTraversal(rootNode));
  }

  /**
   * 前序遍历
   *
   * @param root
   * @return
   */
  public static List<Integer> preOrderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();

    list.add(root.val);

    if (null != root.left) {
      list.addAll(preOrderTraversal(root.left));
    }

    if (null != root.right) {
      list.addAll(preOrderTraversal(root.right));
    }

    return list;
  }

  /**
   * 中序遍历
   *
   * @param root
   * @return
   */
  public static List<Integer> inOrderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();

    if (null != root.left) {
      list.addAll(inOrderTraversal(root.left));
    }

    list.add(root.val);

    if (null != root.right) {
      list.addAll(inOrderTraversal(root.right));
    }

    return list;
  }

  /**
   * 后序遍历
   *
   * @param root
   * @return
   */
  public static List<Integer> postOrderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();

    if (null != root.left) {
      list.addAll(postOrderTraversal(root.left));
    }

    if (null != root.right) {
      list.addAll(postOrderTraversal(root.right));
    }

    list.add(root.val);

    return list;
  }

}
