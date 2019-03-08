package com.droid.java.linkedlist;

/**
 * Created by Muran Hu on 2019-03-04.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class Node {
  private int value;
  Node next;

  public Node(int value, Node next) {
    this.value = value;
    this.next = next;
  }

  public Node(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
