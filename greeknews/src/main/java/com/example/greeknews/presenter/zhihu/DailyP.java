package com.example.greeknews.presenter.zhihu;

import com.example.greeknews.base.BasePresenter;
import com.example.greeknews.bean.zhihu.DailNewsBean;
import com.example.greeknews.collback.zhihu.DailyCollBack;
import com.example.greeknews.model.zhihu.DailyNewsM;
import com.example.greeknews.view.zhihu.DailyV;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class DailyP extends BasePresenter<DailyV> implements DailyCollBack{

    private DailyNewsM mDailNews;

    @Override
    protected void initModel() {
        mDailNews = new DailyNewsM();
        mModel.add(mDailNews);
    }

    @Override
    public void onSuccess(DailNewsBean dailNewsBean) {
        if (mView!=null){
            mView.onSuccess(dailNewsBean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.onFail(msg);
        }
    }

    public void getData(String mDate) {
        mDailNews.getData(mDate,this);
    }
}
