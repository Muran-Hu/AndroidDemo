package com.droid.kotlin.lambda

fun main(args: Array<String>) {
    val a = 10
    val b = 20

    // 调用的时候最后一个参数传递的是匿名函数 lambda 表达式
    // 如果最后一个参数是 lambda 表达式，可以把 () 前移
    cacl(a, b) { m, n ->
        a + b
    }
    cacl(a, b) { m, n->
        a - b
    }

    test1()

    test2()

    test3()

    test4()

    test5()
}

fun test1() {
    // 无参 lambda 表达式
    {
        println("hello")
    }() // 或者通过 invoke 调用
}

fun test2() {
    // 有参 lambda 表达式
    val result = {m:Int, n:Int ->
        m + n
    }.invoke(10, 20)

    println(result)
}

fun test3() {
    // 保存 lambda 表达式
    val block = {m:Int, n:Int ->
        m + n
    }

    block(10, 20)
    block.invoke(10, 20)
}



fun haha(a: Int, block:(Int) -> Int):Int {
    return block(a)
}

val plambda = {m:Int ->
    m + 10
}

fun test4() {
    var a = 10
    // val result = haha(a, plambda)

    // lambda 表达式使用的时候，如果只有一个参数可以省略参数名，默认是通过 it 来实现的
    val result = haha(a) {
        it + 10
    }
}

fun test5(){
    val lambda = {
        10
        "hello"
        'a'
    }
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