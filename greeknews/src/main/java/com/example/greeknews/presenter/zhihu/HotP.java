package com.example.greeknews.presenter.zhihu;

import com.example.greeknews.base.BasePresenter;
import com.example.greeknews.bean.zhihu.HotBean;
import com.example.greeknews.collback.zhihu.HotCollBack;
import com.example.greeknews.model.zhihu.HotM;
import com.example.greeknews.view.zhihu.HotV;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class HotP extends BasePresenter<HotV> implements HotCollBack{

    private HotM hotM;

    @Override
    protected void initModel() {
        hotM = new HotM();
        mModel.add(hotM);
    }

    public void gethot() {
        hotM.gethot(this);
    }

    @Override
    public void onSuccess(HotBean hotBean) {
        if (mView!=null){
            mView.onSuccess(hotBean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.onFail(msg);
        }
    }
}
