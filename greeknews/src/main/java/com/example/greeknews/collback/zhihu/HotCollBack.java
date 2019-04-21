package com.example.greeknews.collback.zhihu;

import com.example.greeknews.bean.zhihu.HotBean;

/**
 * Created by Lenovo on 2019/4/17.
 */

public interface HotCollBack {
    void onSuccess(HotBean hotBean);

    void onFail(String msg);
}
