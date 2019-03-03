package com.droid.kotlin

/**
 * Created by Muran Hu on 2019-02-20.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
fun main() {
    val str: String? = null
    val b = str?.toInt()

    val c:Int = str?.toInt() ?: -1


}