package com.droid.kotlin

import java.util.ArrayList

/**
 * 四大函数
 *
 * apply let with run
 *
 * 除了 with 之外其他都是扩展函数
 */
fun main(args: Array<String>) {
    val list:ArrayList<String>? = arrayListOf("zhangsan", "lisi", "wangwu","zhaoliu")
    list?.add("liushishi")
    list?.add("fanbingbing")
    list?.add("yangmi")

    /**
     * fun <T> T.apply(block: T.() -> Unit): T
     * 1. 任意类型都有 apply 函数扩展
     * 2. apply 参数是一个函数 T.() -> Unit 带接收者的函数字面值
     * 3. lambda 表达式里 this 代表调用的对象
     * 4. 在 lambda 表达式里可以访问对象的方法
     * 5. apply 函数返回值就是调用者本身
     *
     */
    list?.apply {
        this.add("daniu")
        add("xxx")
    }

    /**
     * fun <T, R> T.let(block: (T) -> R): R
     * 1. 任意对象都有 let 扩展函数
     * 2. let 函数参数也是一个函数
     * 3. 函数参数它的参数是调用者本身
     * 4. let 函数返回值是函数参数的返回值，就是 lambda 表达式的返回值
     */
    list?.let {
        it.add("lslsl")
        "haah"
    }

    /**
     * fun <T, R> with(receiver: T, block: T.() -> R): R
     * 1. with 是独立的函数 可以在任意地方调用
     * 2. with 函数需要接收两个参数
     * 3. 第一个参数可以接收任意类型
     * 4. 第二个参数是函数参数，并且这个函数参数是带接收者的函数字面值，接收者就是第一个参数
     * 5. with 函数返回值是第二个函数参数的返回值
     * 6. with 相当于 apply 和 let 的结合
     */
    with(list) {
        this?.add("wwwww")
        10
    }

    /**
     * fun <T, R> T.run(block: T.() -> R): R
     * 1. 任意类型都有 run 扩展函数
     * 2. run 函数参数是带接收者的函数 接收者是调用者本身
     * 3. run 函数返回值就是函数参数的返回值
     */
    list?.run {
        this.add("sdsfdsf")
        true
    }
}