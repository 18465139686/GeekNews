package com.example.greeknews.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Lenovo on 2019/4/3.
 */

public abstract class BaseFragment<V extends BaseView,P extends BasePresenter> extends Fragment implements BaseView{

    public P mPresenter;
    private Unbinder mUnbinder;
    protected EventBus mEventBus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(),null);
        mUnbinder=ButterKnife.bind(this,inflate);
        mPresenter = initPresenter();
        if (mPresenter!=null){
            mPresenter.bind((V) this);
        }
        mEventBus = EventBus.getDefault();
        initView();
        initListener();
        initData();

        return inflate;
    }

    protected void initData() {
    }

    protected void initListener() {
    }

    protected void initView() {
    }

    protected abstract P initPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        mPresenter.onDestory();
        mPresenter=null;
    }
}
