package com.droid.java;

/**
 * Created by Muran Hu on 2018-12-24.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class Main {
  public static void main(String args[]) {
    Runnable runnable = () -> System.out.println("1111111111");

    Thread thread = new Thread(runnable) {
      @Override
      public void run() {
        super.run(); // 只有调用 super.run() 方法，传进来 runnable 中的 run 方法才会执行
        System.out.println("2222222222");
      }
    };
    thread.start();
  }
}
