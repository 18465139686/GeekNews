package com.example.greeknews.fragment.zhihu;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.greeknews.R;
import com.example.greeknews.adapter.zhihu.zhihu.ZhihuVpAdapter;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.presenter.zhihu.ZhihuDailyNewsP;
import com.example.greeknews.view.zhihu.ZhihuDailyNewsV;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuDailyNewsFragment extends BaseFragment<ZhihuDailyNewsV,ZhihuDailyNewsP> implements ZhihuDailyNewsV{

   @BindView(R.id.zhihu_table)
    TabLayout mTable;
   @BindView(R.id.zhihu_Viewpage)
    ViewPager mViewpage;

    private ArrayList<BaseFragment> fraglist;
    private ArrayList<Integer> lsit;


    @Override
    protected ZhihuDailyNewsP initPresenter() {
        return new ZhihuDailyNewsP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhihu_daily_news;
    }

    @Override
    protected void initView() {
        initTitles();
        initFragment();

        ZhihuVpAdapter adapter=new ZhihuVpAdapter(getChildFragmentManager(),fraglist,lsit,getContext());
        mViewpage.setAdapter(adapter);
        mTable.setupWithViewPager(mViewpage);
    }

    private void initFragment() {
        fraglist = new ArrayList<>();
        fraglist.add(new DailyNewsFragment());
        fraglist.add(new SectionsFragment());
        fraglist.add(new HotFragment());
    }

    private void initTitles() {
        lsit = new ArrayList<>();
        lsit.add(R.string.dailyNews);
        lsit.add(R.string.sections);
        lsit.add(R.string.hot);
    }
}
