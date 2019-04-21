package com.example.greeknews.fragment.zhihu;


import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.greeknews.R;
import com.example.greeknews.activity.TimeActivity;
import com.example.greeknews.adapter.zhihu.zhihu.RecyclerDailAdapter;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.bean.zhihu.DailArtioBean;
import com.example.greeknews.bean.zhihu.DailNewsBean;
import com.example.greeknews.presenter.zhihu.DailArtivP;
import com.example.greeknews.presenter.zhihu.DailyP;
import com.example.greeknews.view.zhihu.DailArtivV;
import com.example.greeknews.view.zhihu.DailyV;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DailyNewsFragment extends BaseFragment<DailyV,DailyP> implements DailyV,DailArtivV {

    @BindView(R.id.daily_rlv)
    RecyclerView mrlv;
    @BindView(R.id.daily_fab)
    FloatingActionButton mfabbg;

    ArrayList<DailNewsBean.StoriesBean> list=new ArrayList<>();
    ArrayList<DailNewsBean.TopStoriesBean>  banner=new ArrayList<>();

    private RecyclerDailAdapter adapter;
    private String mDate;
    private String mCurrentDate;

    @Override
    protected DailyP initPresenter() {
        return new DailyP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_daily_news;
    }

    @Override
    protected void initView() {

        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        mCurrentDate = sdf.format(date);
        mEventBus.register(this);

        mrlv.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new RecyclerDailAdapter(getContext(),list,banner);
        mrlv.setAdapter(adapter);

        mfabbg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),TimeActivity.class);
                startActivity(intent);

            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mEventBus.unregister(this);
    }

    @Override
    protected void initData() {
        mPresenter.getData("news/latest");
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void ondata(String date){

        mDate = "news/before/" + date;
        if (!date.isEmpty() && Integer.parseInt(date)<Integer.parseInt(mCurrentDate)){
            String year = date.trim().substring(0, 4);
            String month = date.trim().substring(4, 6);
            String day = date.trim().substring(6);
            adapter.mData = year+"-"+month+"-"+day;
            list.clear();
            banner.clear();
            DailArtivP presenter = new DailArtivP(this);
            presenter.getData(mDate);
        }else {
            adapter.mData = "今日新闻";
            mPresenter.getData("news/latest");
        }

    }

    @Override
    public void onSuccess(DailArtioBean dailNews) {
        List<DailArtioBean.StoriesBean> lists = dailNews.getStories();
        ArrayList<DailNewsBean.StoriesBean> storiesBeans = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            DailArtioBean.StoriesBean bean = lists.get(i);
            DailNewsBean.StoriesBean bean1 = new DailNewsBean.StoriesBean();
            bean1.setImages(bean.getImages());
            bean1.setTitle(bean.getTitle());
            storiesBeans.add(bean1);
        }
        list.addAll(storiesBeans);
        adapter.setArticleList(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onSuccess(DailNewsBean dailNewsBean) {
        adapter.addData(dailNewsBean);
    }
}