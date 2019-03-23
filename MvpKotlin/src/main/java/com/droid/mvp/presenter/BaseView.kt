package com.droid.mvp.presenter

interface BaseView {
    fun showLoading()
    fun hideLoading()
    fun onError()
}