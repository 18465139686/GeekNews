package com.example.greeknews.fragment.zhihu;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.greeknews.R;
import com.example.greeknews.adapter.zhihu.zhihu.RecyclerHotAdapter;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.bean.zhihu.HotBean;
import com.example.greeknews.presenter.zhihu.HotP;
import com.example.greeknews.view.zhihu.HotV;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotFragment extends BaseFragment<HotV,HotP> implements HotV{

    @BindView(R.id.hot_rlv)
    RecyclerView mrlv;

    private ArrayList<HotBean.RecentBean> list=new ArrayList<>();
    private RecyclerHotAdapter adapter;

    @Override
    protected HotP initPresenter() {
        return new HotP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_hot;
    }

    @Override
    protected void initView() {
        mrlv.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new RecyclerHotAdapter(list,getContext());
        mrlv.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        mPresenter.gethot();
    }

    @Override
    public void onSuccess(HotBean hotBean) {
        adapter.setData(hotBean);
    }

    @Override
    public void onFail(String msg) {

    }
}
