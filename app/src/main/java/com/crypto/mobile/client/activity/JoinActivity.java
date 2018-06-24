package com.crypto.mobile.client.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;

import com.crypto.mobile.client.R;
import com.crypto.mobile.client.viewdata.GuideStringInJoin;
import com.crypto.mobile.client.databinding.JoinActivityBinding;
import com.crypto.mobile.client.viewmodel.JoinViewModel;
import com.crypto.mobile.client.data.JoinInfoData;

import java.util.regex.Pattern;


public class JoinActivity extends AppCompatActivity {
    JoinViewModel mJoinViewModel;

    JoinActivityBinding mJoinActivityBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mJoinActivityBinding = DataBindingUtil.setContentView(this, R.layout.join_activity);
        mJoinViewModel = ViewModelProviders.of(this).get(JoinViewModel.class);

        mJoinActivityBinding.setViewmodel(mJoinViewModel);
        mJoinActivityBinding.setCallback(new UICallback());
        mJoinActivityBinding.idEt.setFilters(new InputFilter[] {filterAlphaNum});


        mJoinViewModel.getGuideCode().observe(this, mGuideCodeObserver);
    }

    public class UICallback {
        public void onClickJoinButton(View v) {
            if(mJoinViewModel != null) {
                mJoinViewModel.onClickJoinButton();
            }
        }
    }

    Observer<Integer> mGuideCodeObserver = new Observer<Integer>() {
        @Override
        public void onChanged(@Nullable final Integer guideCode) {
            android.util.Log.d("dong", "GuideCodeObserver guideCode = " + guideCode );
            String guideText = getString(JoinInfoData.getErrorStringId(guideCode));
            if(guideCode == JoinInfoData.NO_ERROR) {
                mJoinActivityBinding.joinBt.setEnabled(true);
            } else {
                mJoinActivityBinding.joinBt.setEnabled(false);
            }
            mJoinActivityBinding.setGuide(new GuideStringInJoin(guideText));
        }
    };

    private InputFilter filterAlphaNum = new InputFilter() {
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            Pattern ps = Pattern.compile("^[a-zA-Z0-9]+$");
            if (!ps.matcher(source).matches()) {
                return "";
            }
            return null;
        }
    };
}
