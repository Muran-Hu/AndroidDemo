package com.jvm;

public class JvmDemo1 {
    public static void main(String[] args) {
//        test1();

//        test2();

//        test3();
    }

    /**
     * 大对象直接进老年代
     * 对象到底是多大才认为是大对象，没有默认值，我们可通过下面参数指定
     * 设置参数：-XX:PretenureSizeThreshold=6M 指定6M及以上对象为大对象，直接进老年代
     */
    private static void test3() {
        byte[] b1 = new byte[5 * 1024 * 1024];
    }

    /**
     * JVM 内存分配测试
     * 需要设置参数 Run - Edit Configuration
     * -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
     * 1. 打印GC详细数据
     * 2. 指定使用 Serial GC 收集器
     * 3. 内存大小设置为 20M
     * 4. 新生代内存大小设置为 10M
     * 5. Eden 空间大小为 8M
     */
    private static void test2() {
        byte[] b1 = new byte[2 * 1024 * 1024];
        byte[] b2 = new byte[2 * 1024 * 1024];
        byte[] b3 = new byte[2 * 1024 * 1024];
        byte[] b4 = new byte[4 * 1024 * 1024];

        System.gc();
    }

    /**
     * 常量池测试
     */
    private static void test1() {
        String s1 = "abc";
        String s2 = "abc";

        System.out.println(s1 == s2); // true

        String s3 = "abc";

        System.out.println(s1 == s3); // false

        System.out.println(s1 == s3.intern()); // true
    }
}
