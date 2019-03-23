package com.droid.mvp.presenter

open class BasePresenter<T:BaseView> {
    lateinit var mView:T
}