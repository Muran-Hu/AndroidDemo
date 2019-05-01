package com.droid.kotlin

fun main(args: Array<String>) {
//    val result = sum1(100000)
//    println(result)
//
//    val res = sum2(100000)
//    println(res)

    val rest = sum3(100000)
    println(rest)
}

/**
 * 迭代方式实现 1 到 n 的和
 * 1 + 2 + 3 + ... + n
 */
fun sum1(n:Int):Int {
    var sum = 0
    var copyN = n
    while (copyN > 0) {
        sum += copyN
        copyN--
    }

    return sum
}

/**
 * 递归方式实现 1 到 n 的和
 * 1 + 2 + 3 + ... + n
 */
fun sum2(n:Int):Int {
    if (n == 1) {
        return 1
    } else {
        return n + sum2(n-1)
    }
}

/**
 * 优化成尾递归
 */
tailrec fun sum3(n:Int, result:Int=0):Int {
    if (n==1) {
        return result+1
    } else {
        return sum3(n-1, result+n)
    }
}