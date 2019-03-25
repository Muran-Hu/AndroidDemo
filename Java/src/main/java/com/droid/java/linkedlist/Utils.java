package com.droid.java.linkedlist;

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

  public static void printNode(Node node) {
    if (null == node) {
      System.out.println("node is null");
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
