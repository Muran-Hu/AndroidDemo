package com.jvm;

/**
 * 逃逸分析与栈上分配
 */
public class JvmDemo2 {

    private JvmDemo2 jvmDemo2;

    /**
     * 方法返回 JvmDemo2 对象，发生逃逸
     *
     * @return
     */
    public  JvmDemo2 getInstance() {
        return jvmDemo2 == null ? new JvmDemo2() : jvmDemo2;
    }

    /**
     * 为成员属性赋值，发生逃逸
     */
    public void setJvmDemo2() {
        this.jvmDemo2 = new JvmDemo2();
    }

    /**
     * 对象的作用域仅在当前方法中有效，没有发生逃逸
     */
    public void useJvmDemo2() {
        JvmDemo2 jvmDemo2 = new JvmDemo2();
    }

    /**
     * 引用成员变量的值，发生逃逸
     */
    public void useJvmDemo() {
        JvmDemo2 jvmDemo2 = getInstance();
    }
}
