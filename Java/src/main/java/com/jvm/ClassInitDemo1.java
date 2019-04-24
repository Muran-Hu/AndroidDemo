package com.jvm;

public class ClassInitDemo1 {
    static {
        i = 0;
//        System.out.println(i); // 可以赋值，但是不可以访问
    }

    static int i;
}
