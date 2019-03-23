package com.droid.mvp.presenter.register

import com.droid.mvp.presenter.BaseView

interface RegisterView:BaseView {
    fun onResult(result:String)
}