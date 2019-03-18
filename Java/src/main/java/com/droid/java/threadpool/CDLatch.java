package com.droid.java.threadpool;

import java.util.concurrent.Executor;

/**
 * Created by Muran Hu on 2019-03-03.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class CDLatch {
  public static void main(String args[]) {
    java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(4);
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
}
