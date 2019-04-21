package com.example.greeknews.service;

import com.example.greeknews.bean.wechat.WechatBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Lenovo on 2019/4/18.
 */

public interface WechatApiService {

    String WechatUrl="http://api.tianapi.com/";

    @GET("wxnew/")
    Observable<WechatBean> getwechat(@QueryMap Map<String,Object> map);

}
