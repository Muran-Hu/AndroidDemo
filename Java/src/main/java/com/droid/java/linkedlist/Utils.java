package com.droid.java.linkedlist;

import java.util.Stack;

/**
 * Created by Muran Hu on 2019-03-04.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class Utils {
  public static Node initLinkedList() {
    Node n5 = new Node(5, null);
    Node n4 = new Node(4, n5);
    Node n3 = new Node(3, n4);
    Node n2 = new Node(2, n3);
    Node n1 = new Node(1, n2);

    Node head = new Node(0, n1);

    return head;
  }

  public static Node initCircledLinkedList() {
    Node n6 = new Node(6);

    Node n5 = new Node(5, n6);
    Node n4 = new Node(4, n5);
    Node n3 = new Node(3, n4);
    Node n2 = new Node(2, n3);
    Node n1 = new Node(1, n2);

    n6.next = n4;

    Node head = new Node(0, n1);

    return head;
  }

  public static Node[] initXLinkedLists() {
    Node n1_1 = new Node(5, null);
    Node n1_2 = new Node(4, n1_1);
    Node n1_3 = new Node(8, n1_2);

    Node n1_4 = new Node(1, n1_3);
    Node n1_5 = new Node(4, n1_4);

    Node n2_4 = new Node(1, n1_3);
    Node n2_5 = new Node(0, n2_4);
    Node n2_6 = new Node(5, n2_5);

    return new Node[]{n1_5, n2_6};
  }

  public static void printNode(Node node) {
    if (null == node) {
      System.out.println("node is null");
      return;
    }

    System.out.println("Node value is: " + node.getValue());
  }

  public static void printAll(Node list) {
    if (null == list) {
      return;
    }

    while (list != null) {
      System.out.println(list.getValue());
      list = list.next;
    }
  }

  public static Node insertToHead(Node list, Node node) {
    if (list == null) {
      return node;
    }

    node.next = list;

    return node;
  }

  public static Node insertToTail(Node list, Node node) {
    if (null == list) {
      return node;
    }

    Node head = list;

    while (list.next != null) {
      list = list.next;
    }

    node.next = null;
    list.next = node;

    return head;
  }

  public static Node deleteFromHead(Node list) {
    Node head = list;
    list = list.next;
    head.next = null;

    return list;
  }

  public static Node deleteFromTail(Node list) {
    Node head = list;
    while (list.next.next != null) {
      list = list.next;
    }

    list.next = null;

    return head;
  }

  public static Node insertBefore(Node list, Node node, Node newNode) {
    Node head = list;
    while (list.next != node) {
      list = list.next;
    }

    newNode.next = node;
    list.next = newNode;

    return head;
  }

  public static Node insertAfter(Node list, Node node, Node newNode) {
    newNode.next = node.next;
    node.next = newNode;

    return list;
  }

  public static Node deleteNodeByValue(Node list, int value) {
    Node head = list;
    while (list.next.getValue() != value) {
      list = list.next;
    }

    list.next = list.next.next;

    return head;
  }

  public static Node getNodeByValue(Node list, int value) {
    while (list != null) {
      if (list.getValue() == value) {
        return list;
      }

      list = list.next;
    }

    return null;
  }

  public static boolean checkCircle(Node list) {
    Node slow = list;
    Node fast = list;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  public static Node reverse(Node list) {
    Node headNode = null;
    Node preNode = null;
    Node currentNode = list;

    while (currentNode != null) {
      Node next = currentNode.next;
      if (next == null) {
        headNode = currentNode;
      }

      currentNode.next = preNode;
      preNode = currentNode;
      currentNode = next;
    }

    return headNode;
  }

  public static Node findMiddleNode(Node list) {
    Node slow = list;
    Node fast = list;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  /**
   * 判断两个单项链表是否相交，如果有相交，则返回相交处节点
   *
   * 1. 将两个链表分别遍历，入栈
   * 2. 从栈中分别取出元素进行比较
   * 3. 如果相等，继续 2
   * 4. 如果不相等，则返回当前节点的next
   *
   * @param nodes
   * @return
   */
  public static Node findXNode(Node[] nodes) {
    Node list1 = nodes[0];
    Node list2 = nodes[1];

    Node tmp = null;

    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();

    while (list1 != null) {
      stack1.push(list1);
      list1 = list1.next;
    }

    while (list2 != null) {
      stack2.push(list2);
      list2 = list2.next;
    }

    while (!stack1.empty() && !stack2.empty()) {
      tmp = stack1.peek();
      if (tmp != stack2.peek()) {
        return tmp.next;
      }

      stack1.pop();
      stack2.pop();
    }

    return tmp;
  }

  /**
   * 判断两个单链表是否相交，如果有相交，则返回相交处节点
   *
   * 1. 分别遍历两个链表，计算其长度值 len1，len2
   * 2. 比较两个链表的最后一个节点是否相等，如果相等，说明有相交
   * 3. detla = Math.abs(len1 - len2)
   * 4. 长链表先遍历 detla 个
   * 5. 此时两个链表长度一致
   * 6. 同时遍历两个链表，找到第一个相同的节点
   *
   * @param nodes
   * @return
   */
  public static Node findXNode1(Node[] nodes) {
    Node p1 = nodes[0];
    Node p2 = nodes[1];

    int len1 = 0;
    while (p1 != null) {
      len1 += 1;
      p1 = p1.next;
    }

    int len2 = 0;
    while (p2 != null) {
      len2 += 1;
      p2 = p2.next;
    }

    int delta = Math.abs(len1 - len2);
    if (len1 > len2) {
      p1 = nodes[0];
      p2 = nodes[1];
    } else {
      p1 = nodes[1];
      p2 = nodes[0];
    }

    for (int i = 0; i < delta; i++) {
      p1 = p1.next;
    }

    while (p1 != p2) {
      p1 = p1.next;
      p2 = p2.next;
    }

    return p1;
  }

  public static boolean checkCircle1(Node list) {
    Node slow = list;
    Node fast = list;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }

    return false;
  }

  public static Node reverse1(Node list) {
    Node headNode = null;
    Node preNode = null;
    Node currentNode = list;
    while (currentNode != null) {
      Node next = currentNode.next;
      if (next == null) {
        headNode = currentNode;
      }

      currentNode.next = preNode;
      preNode = currentNode;
      currentNode = next;
    }

    return headNode;
  }

  public static Node findMiddleNode1(Node list) {
    Node slow = list;
    Node fast = list;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }
}
