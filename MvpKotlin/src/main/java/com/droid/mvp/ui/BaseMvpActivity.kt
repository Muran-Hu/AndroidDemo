package com.droid.mvp.ui

import com.droid.mvp.presenter.BasePresenter
import com.droid.mvp.presenter.BaseView

open class BaseMvpActivity<T:BasePresenter<*>>:BaseActivity(), BaseView {
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    lateinit var mPresenter:T
}