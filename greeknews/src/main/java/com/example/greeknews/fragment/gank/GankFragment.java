package com.example.greeknews.fragment.gank;


import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.greeknews.R;
import com.example.greeknews.activity.ShowActivity;
import com.example.greeknews.adapter.zhihu.goid.GoldVpAdapter;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.base.Constants;
import com.example.greeknews.bean.gank.GankShowBean;
import com.example.greeknews.presenter.gank.GankP;
import com.example.greeknews.view.GankV;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class GankFragment extends BaseFragment<GankV, GankP> implements GankV {

    @BindView(R.id.gank_image)
    ImageView mimage;
    @BindView(R.id.gank_table)
    TabLayout mtable;
    @BindView(R.id.gank_viewpage)
    ViewPager mviewpage;
    private ArrayList<BaseFragment> mfragment;
    private ArrayList<GankShowBean> mlist;

    @Override
    protected GankP initPresenter() {
        return new GankP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_gank;
    }

    @Override
    protected void initView() {
        initTitle();
        setFragment();
    }

    private void setFragment() {
        initFragment();
        GoldVpAdapter adapter = new GoldVpAdapter(getChildFragmentManager(),
                mfragment,mlist);
        mviewpage.setAdapter(adapter);
        mtable.setupWithViewPager(mviewpage);
    }

    private void initFragment() {
        mfragment = new ArrayList<>();
        for (int i = 0; i < mlist.size(); i++) {
            GankShowBean bean = mlist.get(i);
            if (bean.isChecked){
                mfragment.add(GankDataFragment.newInstance(bean.title));
            }
        }
    }

    private void initTitle() {
        mlist = new ArrayList<>();
        mlist.add(new GankShowBean("工具资源",true));
        mlist.add(new GankShowBean("Android",true));
        mlist.add(new GankShowBean("iOS",true));
        mlist.add(new GankShowBean("设计",true));
        mlist.add(new GankShowBean("产品",true));
        mlist.add(new GankShowBean("阅读",true));
        mlist.add(new GankShowBean("前端",true));
        mlist.add(new GankShowBean("后端",true));
    }

    @OnClick({R.id.gank_image})
    public void click(View v){
        switch (v.getId()) {
            case R.id.gank_image:
                go2ShowActivity();
                break;
        }
    }

    private void go2ShowActivity() {
        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(Constants.DATA,mlist);
        startActivityForResult(intent,100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null){
            if (requestCode == 100 && resultCode == Activity.RESULT_OK){
                mlist = (ArrayList<GankShowBean>) data.getSerializableExtra(Constants.DATA);
                //刷新界面
                setFragment();
            }
        }
    }
}
