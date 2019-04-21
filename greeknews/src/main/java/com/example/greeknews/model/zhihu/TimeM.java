package com.example.greeknews.model.zhihu;

import com.example.greeknews.base.BaseModel;

/**
 * Created by Lenovo on 2019/4/19.
 */

public class TimeM extends BaseModel {
//    public void getTime(CalendarDay date, final  TimeCollBack collBack) {
//        ZhihuApiService apiserver = HttpUtils.getInstance().getApiserver(ZhihuApiService.ZhihuUrl, ZhihuApiService.class);
//        Observable<DateBean> time = apiserver.getTime(date);
//        time.compose(RxUtils.<DateBean>rxObserableSchedulerHelper())
//                .subscribe(new BaseObserver<DateBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        mCompositeDisposable.add(d);
//                    }
//
//                    @Override
//                    public void onNext(DateBean dateBean) {
//                        if (dateBean!=null){
//                            collBack.onSuccess(dateBean);
//                        }else {
//                            collBack.onFail("请求失败");
//                        }
//                    }
//                });
//    }
}
