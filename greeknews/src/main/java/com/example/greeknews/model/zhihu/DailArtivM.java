package com.example.greeknews.model.zhihu;

import com.example.greeknews.base.BaseModel;
import com.example.greeknews.bean.zhihu.DailArtioBean;
import com.example.greeknews.collback.zhihu.DailArtrvCollBack;
import com.example.greeknews.net.BaseObserver;
import com.example.greeknews.net.HttpUtils;
import com.example.greeknews.net.RxUtils;
import com.example.greeknews.presenter.zhihu.DailArtivP;
import com.example.greeknews.service.ZhihuApiService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Lenovo on 2019/4/21.
 */

public class DailArtivM extends BaseModel {

    public void getData(String mDate, final DailArtrvCollBack collBack) {
        ZhihuApiService apiserver = HttpUtils.getInstance().getApiserver(ZhihuApiService.ZhihuUrl, ZhihuApiService.class);
        Observable<DailArtioBean> lastDailyNews = apiserver.getNewsArticle(mDate);
        lastDailyNews.compose(RxUtils.<DailArtioBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<DailArtioBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(DailArtioBean dailArtio) {
                        if (dailArtio != null) {
                            collBack.onSuccess(dailArtio);
                        }
                    }
                });
    }
}
