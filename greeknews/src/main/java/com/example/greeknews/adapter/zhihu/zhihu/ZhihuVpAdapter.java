package com.example.greeknews.adapter.zhihu.zhihu;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.greeknews.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class ZhihuVpAdapter extends FragmentPagerAdapter{

    private ArrayList<BaseFragment> fralist;
    private ArrayList<Integer> titls;
    private Context context;

    public ZhihuVpAdapter(FragmentManager fm, ArrayList<BaseFragment> fralist, ArrayList<Integer> titls, Context context) {
        super(fm);
        this.fralist = fralist;
        this.titls = titls;
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return fralist.get(position);
    }

    @Override
    public int getCount() {
        return fralist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(titls.get(position));
    }
}
