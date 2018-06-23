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
    }

    public void onChangedPassword(CharSequence s, int start, int before, int count) {
        android.util.Log.d("dong", "onChangedPassword password = "+ s );
        mPassword = s.toString();
    }

    public void onChangedPasswordConfirmed(CharSequence s, int start, int before, int count) {
        android.util.Log.d("dong", "onChangedPasswordConfirmed password = "+ s );
        mPasswordConfirmed = s.toString();
    }

    public void onClickJoinButton() {
        android.util.Log.d("dong", "onClickJoinButton()");
        mGuideCode.postValue(checkIdAndPassword(mID, mPassword));
    }

    public int checkIdAndPassword(String id, String password) {
        if(id.length() < JoinInfoData.ID_MIN_LENGTH) {
            return JoinInfoData.ERROR_ID_SIZE;
        } else if(isIdDuplicated(id)) {
            return JoinInfoData.ERROR_ID_DUPLICATED;
        } else if(!isOnlyTextAndNumIncluded(id)) {
            return JoinInfoData.ERROR_ID_NO_INCLUDE_SPECIFIC_WORDS;
        } else if(password.length() < JoinInfoData.PASSWORD_MIN_LENGTH) {
            return JoinInfoData.ERROR_PASSWORD_SIZE;
        } else if(!isTextAndNumAndSpecialWordIncluded(password)) {
            return JoinInfoData.ERROR_PASSWORD_NO_INCLUDE_SPECIFIC_WORD;
        }
        return JoinInfoData.NO_ERROR;
    }

    public boolean isTextAndNumAndSpecialWordIncluded(String password) {
        boolean result = true;
        return result;
    }

    public boolean isOnlyTextAndNumIncluded(String id) {
        boolean result = true;
        return result;
    }
    public boolean isIdDuplicated(String id) {
        boolean result = false;
        return result;
    }

    public boolean canUsePassword(String password) {
        boolean result = false;

        return result;
    }

    public boolean comparePasswordConfirmed(String password) {
        boolean result = false;

        return result;
    }


}
