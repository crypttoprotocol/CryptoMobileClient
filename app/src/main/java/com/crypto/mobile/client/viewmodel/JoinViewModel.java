package com.crypto.mobile.client.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.crypto.mobile.client.data.JoinInfoData;

public class JoinViewModel extends ViewModel {
    private String ADMIN_ID = "crypto";
    private String ADMIN_PASSWORD = "crypto";

    private String mID;
    private String mPassword;
    private String mPasswordConfirmed;

    private MutableLiveData<Integer> mGuideCode;

    public MutableLiveData<Integer> getGuideCode() {
        if (mGuideCode == null) {
            mGuideCode = new MutableLiveData<Integer>();
        }
        return mGuideCode;
    }

    public void onChangedID(CharSequence s, int start, int before, int count){
        android.util.Log.d("dong", "onChangedID id = "+s );
        mID = s.toString();
        mGuideCode.postValue(JoinInfoData.checkIdAndPassword(mID, mPassword, mPasswordConfirmed));
    }

    public void onChangedPassword(CharSequence s, int start, int before, int count) {
        android.util.Log.d("dong", "onChangedPassword password = "+ s );
        mPassword = s.toString();
        mGuideCode.postValue(JoinInfoData.checkIdAndPassword(mID, mPassword, mPasswordConfirmed));
    }

    public void onChangedPasswordConfirmed(CharSequence s, int start, int before, int count) {
        android.util.Log.d("dong", "onChangedPasswordConfirmed password = "+ s );
        mPasswordConfirmed = s.toString();
        mGuideCode.postValue(JoinInfoData.checkIdAndPassword(mID, mPassword, mPasswordConfirmed));
    }

    public void onClickJoinButton() {
        android.util.Log.d("dong", "onClickJoinButton()");
    }

}
