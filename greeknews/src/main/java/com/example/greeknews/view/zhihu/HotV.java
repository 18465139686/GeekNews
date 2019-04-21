package com.example.greeknews.view.zhihu;

import com.example.greeknews.base.BaseView;
import com.example.greeknews.bean.zhihu.HotBean;

/**
 * Created by Lenovo on 2019/4/17.
 */

public interface HotV extends BaseView{
    void onSuccess(HotBean hotBean);

    void onFail(String msg);
}
