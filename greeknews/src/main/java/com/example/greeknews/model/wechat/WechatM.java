package com.example.greeknews.model.wechat;

import com.example.greeknews.base.BaseModel;
import com.example.greeknews.bean.wechat.WechatBean;
import com.example.greeknews.collback.wechat.WechatCollBack;
import com.example.greeknews.net.BaseObserver;
import com.example.greeknews.net.HttpUtils;
import com.example.greeknews.net.RxUtils;
import com.example.greeknews.presenter.wechat.WeChatP;
import com.example.greeknews.service.WechatApiService;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Lenovo on 2019/4/18.
 */

public class WechatM extends BaseModel {
    public void getWechat(HashMap<String, Object> mMap, final WechatCollBack collBack) {
        WechatApiService apiserver = HttpUtils.getInstance().getApiserver(WechatApiService.WechatUrl, WechatApiService.class);
        Observable<WechatBean> getwechat = apiserver.getwechat(mMap);
        getwechat.compose(RxUtils.<WechatBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<WechatBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(WechatBean wechatBean) {
                        if (wechatBean!=null){
                            collBack.onSuccess(wechatBean);
                        }else{
                            collBack.onFail("请求失败");
                        }
                    }
                });
    }


}
