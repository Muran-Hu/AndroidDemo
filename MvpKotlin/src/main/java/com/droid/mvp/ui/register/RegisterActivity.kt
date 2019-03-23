package com.droid.mvp.ui.register

import android.os.Bundle
import com.droid.mvp.R
import com.droid.mvp.presenter.register.RegisterPresenter
import com.droid.mvp.presenter.register.RegisterView
import com.droid.mvp.ui.BaseMvpActivity
import kotlinx.android.synthetic.main.register.*
import org.jetbrains.anko.toast

class RegisterActivity:BaseMvpActivity<RegisterPresenter>(), RegisterView {
    override fun onResult(result:String) {
        toast("Register Succeed! $result")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        mPresenter = RegisterPresenter()
        mPresenter.mView = this

        mBtn.setOnClickListener {
            mPresenter.register("zhangsan", "123456")
        }
    }
}