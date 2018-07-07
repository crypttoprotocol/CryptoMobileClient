package com.crypto.mobile.client.viewmodel;

import android.arch.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel{
    private String TAG = "LoginViewModel";
    private String mID;
    private String mPassword;

    public void onTextChangedinID(CharSequence s, int start, int before, int count){
        android.util.Log.d("dong", TAG +"/onTextChangedinID id = "+ s);

    }

    public void onTextChangedInPassword(CharSequence s, int start, int before, int count){
        android.util.Log.d("dong", TAG +"/onTextChangedInPassword");

    }

    public void login() {

    }

    public void googleLogin() {

    }



}
