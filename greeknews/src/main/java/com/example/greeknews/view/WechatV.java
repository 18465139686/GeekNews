package com.example.greeknews.view;

import com.example.greeknews.base.BaseView;
import com.example.greeknews.bean.wechat.WechatBean;

/**
 * Created by Lenovo on 2019/4/3.
 */

public interface WechatV extends BaseView {
    void onSuccess(WechatBean wechatBean);

    void onFail(String msg);
}
