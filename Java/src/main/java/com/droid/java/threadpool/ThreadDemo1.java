package com.droid.java.threadpool;

public class ThreadDemo1 {
    public static void main(String[] args) {
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();
        MyRunnable r3 = new MyRunnable();

        Thread t5 = new Thread(r1);
        Thread t6 = new Thread(r2);
        Thread t7 = new Thread(r3);

        t5.start();
        t6.start();
        t7.start();
    }
}
