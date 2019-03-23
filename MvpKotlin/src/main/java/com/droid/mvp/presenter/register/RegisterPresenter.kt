package com.droid.mvp.presenter.register

import com.droid.mvp.presenter.BasePresenter

class RegisterPresenter:BasePresenter<RegisterView>() {
    fun register(username:String, password:String) {
        val result = "[$username, $password]"

        mView.onResult(result)
    }
}