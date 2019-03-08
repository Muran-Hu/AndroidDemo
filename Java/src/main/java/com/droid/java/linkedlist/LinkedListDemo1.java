package com.droid.java.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class LinkedListDemo1 {

  public static void main(String args[]) {
    LinkedList list = new LinkedList();
    list.add("a");
    list.add("b");
    list.add("c");

    list.addFirst("1");
    list.addFirst("2");
    list.addFirst("3");

    list.addLast("+");
    list.addLast("-");
    list.addLast("x");

    for (ListIterator it = list.listIterator(); it.hasNext();) {
      System.out.println(it.next());
    }
  }
}
