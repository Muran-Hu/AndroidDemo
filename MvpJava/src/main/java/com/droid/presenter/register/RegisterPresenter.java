package com.droid.presenter.register;

import com.droid.presenter.BasePresenter;

public class RegisterPresenter extends BasePresenter<RegisterView> {
    public void register(String username, String password) {
        mView.onResult("[" + username + ", " + password + "]");
    }
}
