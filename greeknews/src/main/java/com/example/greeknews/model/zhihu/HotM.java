package com.example.greeknews.model.zhihu;

import com.example.greeknews.base.BaseModel;
import com.example.greeknews.bean.zhihu.HotBean;
import com.example.greeknews.collback.zhihu.HotCollBack;
import com.example.greeknews.net.BaseObserver;
import com.example.greeknews.net.HttpUtils;
import com.example.greeknews.net.RxUtils;
import com.example.greeknews.service.ZhihuApiService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class HotM extends BaseModel {
    public void gethot(final HotCollBack collBack) {
        ZhihuApiService apiserver = HttpUtils.getInstance().getApiserver(ZhihuApiService.ZhihuUrl, ZhihuApiService.class);
        Observable<HotBean> gethot = apiserver.gethot();
        gethot.compose(RxUtils.<HotBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<HotBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(HotBean hotBean) {
                        if (hotBean!=null){
                            collBack.onSuccess(hotBean);
                        }else{
                            collBack.onFail("请求失败");
                        }
                    }
                });

    }
}
