package com.droid.kotlin

fun main(args: Array<String>) {
    val result = test()
    result() // 10
    result() // 11
    result() // 12
}

fun test():()->Unit{
    var a = 10
    return {
        println(a)
        a++
    }
}