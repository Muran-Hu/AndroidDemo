package com.droid.kotlin

fun main(args: Array<String>) {
    sendRequest("https://www.baidu.com", "GET") // 方法调用方式一
    sendRequest("https://www.baidu.com") // 方法调用方式二
    sendRequest(method = "GET", path = "https://www.baicu.com") // 方法调用方式三：具名参数，参数位置可以变化
}

fun sendRequest(path:String, method:String="GET") { // 默认参数，只有设置默认参数之后，才可以采用方式二调用
    println("path=$path, method=$method")
}