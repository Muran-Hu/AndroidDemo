package com.droid.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.droid.R;
import com.droid.databinding.LoginBinding;
import com.droid.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginBinding binding = DataBindingUtil.setContentView(this, R.layout.login);
        LoginViewModel viewModel = new LoginViewModel(this);
        binding.setViewModel(viewModel);
    }
}
