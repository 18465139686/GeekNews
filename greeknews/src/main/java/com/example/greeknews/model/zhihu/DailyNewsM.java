package com.example.greeknews.model.zhihu;

import com.example.greeknews.base.BaseModel;
import com.example.greeknews.bean.zhihu.DailNewsBean;
import com.example.greeknews.collback.zhihu.DailyCollBack;
import com.example.greeknews.net.BaseObserver;
import com.example.greeknews.net.HttpUtils;
import com.example.greeknews.net.RxUtils;
import com.example.greeknews.service.ZhihuApiService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class DailyNewsM extends BaseModel{
    public void getData(String mDate, final DailyCollBack collBack) {
        ZhihuApiService apiserver = HttpUtils.getInstance().getApiserver(ZhihuApiService.ZhihuUrl, ZhihuApiService.class);
        final Observable<DailNewsBean> dailNews = apiserver.getDailNews(mDate);
        dailNews.compose(RxUtils.<DailNewsBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailNewsBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DailNewsBean dailNewsBean) {
                        if (dailNewsBean!=null){
                            collBack.onSuccess(dailNewsBean);
                        }else{
                            collBack.onFail("请求失败");
                        }
                    }
                });
    }
}
