package com.example.greeknews.fragment;


import android.support.v4.app.Fragment;

import com.example.greeknews.R;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.presenter.AbouP;
import com.example.greeknews.view.AboutV;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends BaseFragment<AboutV,AbouP> implements AboutV{

    @Override
    protected AbouP initPresenter() {
        return new AbouP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }
}
