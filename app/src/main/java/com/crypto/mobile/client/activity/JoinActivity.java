package com.crypto.mobile.client.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crypto.mobile.client.R;
import com.crypto.mobile.client.data.GuideStringInJoin;
import com.crypto.mobile.client.databinding.JoinActivityBinding;
import com.crypto.mobile.client.viewmodel.JoinViewModel;
import com.crypto.mobile.client.data.JoinInfoData;


public class JoinActivity extends AppCompatActivity {
    JoinViewModel mJoinViewModel;
    GuideStringInJoin mGuideString;
    JoinActivityBinding mJoinActivityBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mJoinActivityBinding = DataBindingUtil.setContentView(this, R.layout.join_activity);
        mJoinViewModel = ViewModelProviders.of(this).get(JoinViewModel.class);
        mJoinActivityBinding.setViewmodel(mJoinViewModel);
        mJoinActivityBinding.setCallback(new UICallback());
        mGuideString = new GuideStringInJoin();

        final Observer<Integer> guideCodeObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable final Integer guideCode) {
                String guideText = getString(JoinInfoData.getErrorStringId(guideCode));
                mGuideString.setGuideText(guideText);
                mJoinActivityBinding.setGuide(mGuideString);
            }
        };
        mJoinViewModel.getGuideCode().observe(this, guideCodeObserver);
    }

    public class UICallback {
        public void onClickJoinButton(View v) {
            if(mJoinViewModel != null) {
                mJoinViewModel.onClickJoinButton();
            }
        }
    }
}
