package com.example.greeknews.fragment.zhihu;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.greeknews.R;
import com.example.greeknews.adapter.zhihu.zhihu.RecyclerSectAdapter;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.bean.zhihu.SectionBean;
import com.example.greeknews.presenter.zhihu.SectionsP;
import com.example.greeknews.view.zhihu.SectionsV;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SectionsFragment extends BaseFragment<SectionsV,SectionsP> implements SectionsV{

    @BindView(R.id.sect_rlv)
    RecyclerView mrlv;

    private ArrayList<SectionBean.DataBean> list=new ArrayList<>();
    private RecyclerSectAdapter adapter;

    @Override
    protected SectionsP initPresenter() {
        return new SectionsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sections;
    }

    @Override
    protected void initView() {
        mrlv.setLayoutManager(new GridLayoutManager(getContext(),2));

        adapter = new RecyclerSectAdapter(list,getContext());
        mrlv.setAdapter(adapter);

    }

    @Override
    protected void initData() {
        mPresenter.getSectData();
    }

    @Override
    public void onSuccess(SectionBean sectionBean) {
        adapter.setData(sectionBean);
    }

    @Override
    public void onFail(String msg) {

    }
}
