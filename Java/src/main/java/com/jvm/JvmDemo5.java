package com.jvm;

/**
 * 1. 准备阶段正式为类变量分配内存并设置变量的初始值。这些变量使用的内存都将在方法区中进行分配
 *     1. 注意：这里提到的是类变量，也就是全局变量，会赋初始值
 *     2. 对于局部变量，也就是方法中的变量，没有赋初始值
 */
public class JvmDemo5 {
    private int a;
    private int b;

    int add() {
        return a + b;
    }

    int add1() {
        int a = 1;
        int b = 2;

        return a + b; // 如果 a, b 不赋值，会报错：Variable 'b' might not have been initialized
    }
}
