package com.example.greeknews.activity;

import android.content.Intent;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.greeknews.R;
import com.example.greeknews.adapter.zhihu.goid.RecyclerShowAdapter;
import com.example.greeknews.base.BaseActivity;
import com.example.greeknews.base.Constants;
import com.example.greeknews.bean.gank.GankShowBean;
import com.example.greeknews.presenter.AbouP;
import com.example.greeknews.view.AboutV;
import com.example.greeknews.widget.SimpleTouchHelperCallBack;

import java.util.ArrayList;

import butterknife.BindView;

public class ShowActivity extends BaseActivity<AboutV,AbouP> implements AboutV{

    @BindView(R.id.toolBar)
    Toolbar show_mToolBar;
    @BindView(R.id.rlv)
    RecyclerView show_mRlv;

    private ArrayList<GankShowBean> mList;

    @Override
    protected AbouP initPresenter() {
        return new AbouP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_show;
    }

    @Override
    protected void initView() {
        mList = (ArrayList<GankShowBean>) getIntent().getSerializableExtra(Constants.DATA);

        show_mToolBar.setTitle(R.string.special_show);
        show_mToolBar.setNavigationIcon(R.mipmap.ic_close);
        setSupportActionBar(show_mToolBar);

        show_mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAct();
            }
        });

        show_mRlv.setLayoutManager(new LinearLayoutManager(this));
        RecyclerShowAdapter adapter = new RecyclerShowAdapter(mList);
        show_mRlv.setAdapter(adapter);
        show_mRlv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        //拖拽移动和侧滑删除的功能
        SimpleTouchHelperCallBack simpleTouchHelperCallBack=new SimpleTouchHelperCallBack(adapter);
        simpleTouchHelperCallBack.setSwipeEnable(true);
        ItemTouchHelper helper=new ItemTouchHelper(simpleTouchHelperCallBack);
        helper.attachToRecyclerView(show_mRlv);

    }

    private void finishAct() {
        Intent intent = new Intent();
        intent.putExtra(Constants.DATA, mList);
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finishAct();
    }
}
