package com.droid.java;

import com.droid.java.designpattern.observer.Coder;
import com.droid.java.designpattern.observer.DevTechFrontier;
import com.droid.java.threadpool.ExecutorManager;
import com.droid.java.threadpool.Worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/**
 * Created by Muran Hu on 2018-12-24.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class Main {
  public static void main(String args[]) {
//    observerTester();

//    countDownLatchTester();

    containerTester();

  }

  /**
   * 测试Java中的集合
   *
   */
  private static void containerTester() {
    listTester();

    setTester();

    mapTester();
  }

  private static void listTester() {
    List linkList = new LinkedList();

    List arrayList = new ArrayList();

    Vector vector = new Vector();

    Stack stack = new Stack();
  }

  private static void setTester() {
    Set hashSet = new HashSet();

    Set treeSet = new TreeSet();

    Set linkedSet = new LinkedHashSet();
  }

  private static void mapTester() {
    Map hashTable = new Hashtable();

    Map hashMap = new HashMap();

    Map weakHashMap = new WeakHashMap();
  }

  /**
   * 测试 CountDownLatch
   *
   */
  private static void countDownLatchTester() {
    CountDownLatch countDownLatch = new CountDownLatch(4);
    Executor executor = ExecutorManager.createExecutor();

    System.out.println("Main is ready...");

    executor.execute(new Worker("Zhang san", countDownLatch));
    executor.execute(new Worker("Li si", countDownLatch));
    executor.execute(new Worker("Wang wu", countDownLatch));
    executor.execute(new Worker("Zhao liu", countDownLatch));

    try {
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Main is working...");
  }

  /**
   * 测试观察者模式
   *
   */
  private static void observerTester() {
    Coder coder = new Coder("mr.simple");
    Coder coder1 = new Coder("coder-1");
    Coder coder2 = new Coder("coder-2");
    Coder coder3 = new Coder("coder-3");

    DevTechFrontier devTechFrontier = new DevTechFrontier();

    devTechFrontier.addObserver(coder);
    devTechFrontier.addObserver(coder1);
    devTechFrontier.addObserver(coder2);
    devTechFrontier.addObserver(coder3);

    devTechFrontier.postNewPublication("Hello");
  }
}
