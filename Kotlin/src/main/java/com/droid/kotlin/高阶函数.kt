package com.droid.kotlin.aa

fun main(args: Array<String>) {
    val a = 10
    val b = 20

    cacl(a, b, ::add)
    cacl(a, b, ::sub)
}

/**
 * 第三个参数是函数类型，说明 kotlin 里面的函数可以传递函数参数，
 * 如果函数里面传递函数参数的话，就称为高阶函数
 */
fun cacl(a:Int, b:Int, block:(Int, Int) -> Int):Int {

    return block(a, b)
}

fun add(a:Int, b:Int):Int {
    return a + b
}

fun sub(a:Int, b:Int):Int {
    return a - b
}