package com.droid.viewmodel;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

public class LoginViewModel {
    private Context context;
    private String name;
    private String pwd;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public TextWatcher nameChangedListener() {
        return new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    public TextWatcher pwdChangedListener() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pwd = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }

    public void login(View view) {
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
            if (name.equals("zhangsan") && pwd.equals("123456")) {
                Toast.makeText(context, "Login succeed", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(context, "Login failed", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(context, "name or pwd is empty", Toast.LENGTH_LONG).show();
        }
    }
}
