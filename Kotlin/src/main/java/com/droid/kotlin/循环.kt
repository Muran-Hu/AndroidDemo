package com.droid.kotlin

fun main(args: Array<String>) {
    val list = listOf<String>("a", "b", "c")
    list.forEach {
        println(it)
    }
}