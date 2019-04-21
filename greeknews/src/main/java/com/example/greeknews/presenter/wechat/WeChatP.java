package com.example.greeknews.presenter.wechat;

import com.example.greeknews.base.BasePresenter;
import com.example.greeknews.bean.wechat.WechatBean;
import com.example.greeknews.collback.wechat.WechatCollBack;
import com.example.greeknews.model.wechat.WechatM;
import com.example.greeknews.view.WechatV;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo on 2019/4/3.
 */

public class WeChatP extends BasePresenter<WechatV> implements WechatCollBack{

    private WechatM model;

    @Override
    protected void initModel() {
        model = new WechatM();
        mModel.add(model);
    }

    @Override
    public void onSuccess(WechatBean wechatBean) {
        if (mView!=null){
            mView.onSuccess(wechatBean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.onFail(msg);
        }
    }

    public void getwechat(HashMap<String, Object> mMap) {
        model.getWechat(mMap,this);
    }


}
