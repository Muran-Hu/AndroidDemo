package com.jvm;

public class Child extends Parent {
    static {
        System.out.println("child init...");
    }

    public static final int age = 10;

}
