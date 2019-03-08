package com.droid.java.linkedlist;

import java.util.LinkedList;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class MyQueue {
  private LinkedList list;

  public MyQueue() {
    list = new LinkedList();
  }

  public void add(String el) {
    list.addFirst(el); // 堆栈：后进先出
//    list.addLast(el); // 队列：先进先出
  }

  public String get() {
    return list.removeFirst().toString();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
}
