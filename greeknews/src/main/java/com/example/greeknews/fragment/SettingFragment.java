package com.example.greeknews.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greeknews.R;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.presenter.SettingP;
import com.example.greeknews.view.SettingV;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends BaseFragment<SettingV,SettingP> implements SettingV{


    @Override
    protected SettingP initPresenter() {
        return new SettingP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_setting;
    }
}
