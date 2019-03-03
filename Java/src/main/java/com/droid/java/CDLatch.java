package com.droid.java;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * Created by Muran Hu on 2019-03-03.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class CDLatch {
  public static void main(String args[]) {
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
}
