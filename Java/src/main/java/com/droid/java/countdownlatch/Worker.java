package com.droid.java.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Muran Hu on 2019-03-03.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class Worker implements Runnable {

  String name;
  CountDownLatch latch;

  public Worker(String name, CountDownLatch countDownLatch) {
    this.name = name;
    this.latch = countDownLatch;
  }

  @Override
  public void run() {
    doWork();
    latch.countDown();
  }

  private void doWork() {
    System.out.println("Worker " + name + " is working....");
  }
}
