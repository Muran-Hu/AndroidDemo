package com.droid.kotlin

fun main(args: Array<String>) {

    // 函数类型引用
    val padd = ::add // 获取 add 函数的引用
    // 通过 padd 调用 add 函数
    println(padd(10, 20))
    println(padd.invoke(2, 8)) // 可以处理函数变量为空的情况下调用

    // 函数类型变量
    val nadd:(Int, Int)->Int = {a, b -> a + b} // 匿名函数
}

fun add(a:Int, b:Int):Int {
    return a + b
}