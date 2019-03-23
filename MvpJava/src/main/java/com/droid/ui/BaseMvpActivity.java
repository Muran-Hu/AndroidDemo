package com.droid.ui;

import com.droid.presenter.BasePresenter;
import com.droid.presenter.BaseView;

public class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError() {

    }

    public T mPresenter;
}
