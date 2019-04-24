package com.jvm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JvmDemo4 {

    static class Hello {
       static  {
           if (true) {
               System.out.println(Thread.currentThread().getName() + " init...");
               while (true) {}
           }

           try {
               Thread.sleep(5000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        int i = 0;
        while (i++ < 5) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " start");
                Hello hello = new Hello();
                System.out.println(Thread.currentThread().getName() + " end");
            });
        }
    }
}
