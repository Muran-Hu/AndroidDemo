package com.droid.kotlin

fun main(args: Array<String>) {
    println(max(10, 20))
}

fun max(a:Int, b:Int):Int{
    return if (a > b) a else b
}

fun check(age:Int):String{
    return when (age) {
        1 -> "a"
        2 -> "b"
        else -> "c"
    }
}