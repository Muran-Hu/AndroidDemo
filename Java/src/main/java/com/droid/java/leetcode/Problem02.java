package com.droid.java.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muran Hu on 2019-03-08.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class Problem02 {
  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(4);
    ListNode l3 = new ListNode(3);
    l1.next = l2;
    l2.next = l3;

    ListNode l4 = new ListNode(5);
    ListNode l5 = new ListNode(6);
    ListNode l6 = new ListNode(4);
    l4.next = l5;
    l5.next = l6;

    addTwoNumbers(l1, l4);
  }

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode headNode = null;

    StringBuilder sb1 = new StringBuilder();
    while(l1 != null) {
      sb1.append(l1.val);
      l1 = l1.next;
    }

    StringBuilder sb2 = new StringBuilder();
    while(l2 != null) {
      sb2.append(l2.val);
      l2 = l2.next;
    }

    int a = Integer.valueOf(sb1.toString());
    int b = Integer.valueOf(sb2.toString());
    int result = a + b;
    String str = String.valueOf(result);
    System.out.println(str);

    return headNode;
  }
}
