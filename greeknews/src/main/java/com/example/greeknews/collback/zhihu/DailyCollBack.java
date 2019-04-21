package com.example.greeknews.collback.zhihu;

import com.example.greeknews.bean.zhihu.DailNewsBean;

/**
 * Created by Lenovo on 2019/4/17.
 */

public interface DailyCollBack<T> {

    void onSuccess(DailNewsBean dailNewsBean);

    void onFail(String msg);
}
