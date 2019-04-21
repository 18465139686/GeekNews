package com.example.greeknews.model.zhihu;

import com.example.greeknews.base.BaseModel;
import com.example.greeknews.bean.zhihu.SectionBean;
import com.example.greeknews.collback.zhihu.SectionCollBack;
import com.example.greeknews.net.BaseObserver;
import com.example.greeknews.net.HttpUtils;
import com.example.greeknews.net.RxUtils;
import com.example.greeknews.presenter.zhihu.SectionsP;
import com.example.greeknews.service.ZhihuApiService;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class SectionM extends BaseModel {
    public void getSection(final SectionCollBack collBack) {
        ZhihuApiService apiserver = HttpUtils.getInstance().getApiserver(ZhihuApiService.ZhihuUrl, ZhihuApiService.class);
        final Observable<SectionBean> section = apiserver.getSection();
        section.compose(RxUtils.<SectionBean>rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<SectionBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mCompositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(SectionBean sectionBean) {
                        if (sectionBean!=null){
                            collBack.onSuccess(sectionBean);
                        }else{
                            collBack.onFail("请求失败");
                        }
                    }
                });
    }
}
