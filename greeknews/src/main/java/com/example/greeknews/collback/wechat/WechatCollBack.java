package com.example.greeknews.collback.wechat;

import com.example.greeknews.bean.wechat.WechatBean;

/**
 * Created by Lenovo on 2019/4/18.
 */

public interface WechatCollBack {
    void onSuccess(WechatBean wechatBean);

    void onFail(String msg);
}
