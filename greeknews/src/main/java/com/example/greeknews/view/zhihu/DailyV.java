package com.example.greeknews.view.zhihu;

import com.example.greeknews.base.BaseView;
import com.example.greeknews.bean.zhihu.DailNewsBean;

/**
 * Created by Lenovo on 2019/4/17.
 */

public interface DailyV extends BaseView{

    void onFail(String msg);

    void onSuccess(DailNewsBean dailNewsBean);
}
