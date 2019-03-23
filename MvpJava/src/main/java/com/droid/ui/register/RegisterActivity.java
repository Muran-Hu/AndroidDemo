package com.droid.ui.register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.droid.R;
import com.droid.presenter.register.RegisterPresenter;
import com.droid.presenter.register.RegisterView;
import com.droid.ui.BaseMvpActivity;

public class RegisterActivity extends BaseMvpActivity<RegisterPresenter> implements RegisterView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        mPresenter = new RegisterPresenter();
        mPresenter.mView = this;
    }

    public void click(View view) {
        mPresenter.register("zhangsan", "123456");
    }


    @Override
    public void onResult(String result) {
        System.out.println(result);
    }
}
