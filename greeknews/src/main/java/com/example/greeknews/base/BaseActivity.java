package com.example.greeknews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/4/3.
 */

public abstract class BaseActivity<V extends BaseView,P extends BasePresenter> extends AppCompatActivity implements BaseView{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        mPresenter = initPresenter();
        if (mPresenter!=null){
            mPresenter.bind((V) this);
        }
        initView();
        initListener();
        initData();

    }

    protected abstract int getLayoutId();

    protected void initData() {

    }

    protected void initListener() {

    }

    protected void initView() {
    }

    protected abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //切断V层和P层的联系
        mPresenter.onDestory();
        mPresenter=null;
    }
}
