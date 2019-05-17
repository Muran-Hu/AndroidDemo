package com.droid.java.linkedlist;

/**
 * Created by Muran Hu on 2019-03-04.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class LinkedListDemo {
  public static void main(String[] args){
    Node list = Utils.initLinkedList();

    Node newHead = new Node(-1, null);
    Node newTail = new Node(6, null);
//    Utils.printAll(Utils.insertToHead(list, newHead));
//    Utils.printAll(Utils.insertToTail(list, newTail));

//    Utils.printAll(Utils.deleteFromHead(list));
//    Utils.printAll(Utils.deleteFromTail(list));

//    Utils.printAll(Utils.insertBefore(list, Utils.getNodeByValue(list, 3), new Node(100, null)));
//    Utils.printAll(Utils.insertAfter(list, Utils.getNodeByValue(list, 3), new Node(200, null)));

      Utils.printAll(Utils.deleteNodeByValue(list, 3));

//    Utils.printAll(list);
  }
}
