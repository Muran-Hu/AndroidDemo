package com.droid.java.linkedlist;

/**
 * Created by Muran Hu on 2019-03-04.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class LinkedListDemo2 {
  public static void main(String args[]){
    Node list = Utils.initLinkedList();
    Node list2 = Utils.initCircledLinkedList();

    System.out.println(Utils.checkCircle2(list));
    System.out.println(Utils.checkCircle2(list2));

    Utils.printAll(Utils.reverse3(list));
  }
}
