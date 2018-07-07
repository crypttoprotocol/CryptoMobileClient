package com.crypto.mobile.client.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crypto.mobile.client.R;
import com.crypto.mobile.client.databinding.LoginActivityBinding;
import com.crypto.mobile.client.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    LoginViewModel mLoginViewModel;
    LoginActivityBinding mLoginActivityBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginActivityBinding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        mLoginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        mLoginActivityBinding.setCallback(new UICallback());
        mLoginActivityBinding.setViewmodel(mLoginViewModel);
    }

    public class UICallback {
        public void onClickLoginButton(View v) {
            if(mLoginViewModel != null) {
                mLoginViewModel.login();
            }
        }

        public void onClickGoogleLoginButton(View v) {
            if(mLoginViewModel != null) {
                mLoginViewModel.googleLogin();
            }
        }

        public void onClickJoinButton(View v) {
            Intent i = new Intent(v.getContext(), JoinActivity.class);
            startActivity(i);
        }
    }
}
