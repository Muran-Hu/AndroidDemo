package com.droid.java.linkedlist;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class MyQueueTest {
  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();

    myQueue.add("abc1");
    myQueue.add("abc2");
    myQueue.add("abc3");

    while (!myQueue.isEmpty()) {
      System.out.println(myQueue.get());
    }
  }
}
