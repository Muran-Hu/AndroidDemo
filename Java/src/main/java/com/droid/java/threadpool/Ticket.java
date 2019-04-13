package com.droid.java.threadpool;

public class Ticket extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("ticket running..." + getName());
    }
}
