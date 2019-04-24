package com.jvm;

public class ClassInitDemo2 {
    public static int A = 1;
    static {
        A = 2;
    }

    static class Sub extends ClassInitDemo2 {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B); // 2
    }
}
