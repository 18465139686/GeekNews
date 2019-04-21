package com.example.greeknews.service;

import com.example.greeknews.bean.zhihu.DailArtioBean;
import com.example.greeknews.bean.zhihu.DailNewsBean;
import com.example.greeknews.bean.zhihu.HotBean;
import com.example.greeknews.bean.zhihu.SectionBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Lenovo on 2019/4/17.
 */

public interface ZhihuApiService {
    String ZhihuUrl="http://news-at.zhihu.com/api/4/";

    //日报
    @GET()
    Observable<DailNewsBean> getDailNews(@Url String url);

    @GET()
    Observable<DailArtioBean> getNewsArticle(@Url String url);

    //热门
    @GET("news/hot")
    Observable<HotBean> gethot();

    @GET("sections")
    Observable<SectionBean> getSection();

//    @GET("news/before/{date}")
//    Observable<DateBean> getTime(@Query("date") CalendarDay date);
}
