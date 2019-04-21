package com.example.greeknews.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.greeknews.R;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.presenter.CollectP;
import com.example.greeknews.view.CollectV;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectionFragment extends BaseFragment<CollectV,CollectP> implements CollectV{

    @Override
    protected CollectP initPresenter() {
        return new CollectP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collection;
    }
}
