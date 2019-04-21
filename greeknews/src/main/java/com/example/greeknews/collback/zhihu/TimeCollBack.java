package com.example.greeknews.collback.zhihu;

import com.example.greeknews.bean.zhihu.DateBean;

/**
 * Created by Lenovo on 2019/4/19.
 */

public interface TimeCollBack {
    void onSuccess(DateBean dateBean);

    void onFail(String msg);
}
