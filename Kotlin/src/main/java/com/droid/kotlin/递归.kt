package com.droid.kotlin

fun main(args: Array<String>) {
    val fact = fact(5)
    println(fact)

    val fab = fibonacci(10)
    println(fab)
}

/**
 * 递归求阶乘
 */
fun fact(n:Int):Int {
    return if (n==1) 1 else n * fact(n-1)
}

/**
 * 斐波那锲数列：1 1 2 3 5 8 13 21 34 55
 */
fun fibonacci(n:Int):Int {
    return when(n) {
        1 -> 1
        2 -> 1
        else -> fibonacci(n-1) + fibonacci(n-2)
    }
}