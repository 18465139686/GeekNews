package com.example.greeknews.fragment.gank;

import android.os.Bundle;
import android.widget.TextView;

import com.example.greeknews.R;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.base.Constants;
import com.example.greeknews.presenter.gank.GankDataP;
import com.example.greeknews.view.gold.GankDataV;

import butterknife.BindView;

/**
 * Created by Lenovo on 2019/4/18.
 */

public class GankDataFragment extends BaseFragment<GankDataV,GankDataP> implements GankDataV {

    @BindView(R.id.gankda_tv)
    TextView mTv;
    @Override
    protected GankDataP initPresenter() {
        return new GankDataP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank_detail;
    }

    @Override
    protected void initView() {
        Bundle arguments = getArguments();
        String data = arguments.getString(Constants.DATA);
        mTv.setText(data);
    }

    public static GankDataFragment newInstance(String text){
        GankDataFragment fragment = new GankDataFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.DATA,text);
        fragment.setArguments(bundle);
        return fragment;
    }
}
