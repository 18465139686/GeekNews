package com.example.greeknews.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greeknews.R;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.presenter.V2exP;
import com.example.greeknews.view.V2exV;

/**
 * A simple {@link Fragment} subclass.
 */
public class V2EXFragment extends BaseFragment<V2exV,V2exP> implements V2exV {


    @Override
    protected V2exP initPresenter() {
        return new V2exP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_v2_ex;
    }
}
