package com.droid.java.threadlocal;

public class ThreadLocalDemo {
    private static final ThreadLocal<String> tLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        tLocal.set("Main");
        System.out.println(tLocal.get());

        Thread t1 = new Thread(() -> {
              tLocal.set("t1");
                System.out.println(tLocal.get());
            }
        );
        t1.start();

        Thread t2 = new Thread(() -> System.out.println(tLocal.get()));
        t2.start();
    }
}
