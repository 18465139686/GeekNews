package com.example.greeknews.collback.zhihu;

import com.example.greeknews.bean.zhihu.SectionBean;

/**
 * Created by Lenovo on 2019/4/17.
 */

public interface SectionCollBack {
    void onSuccess(SectionBean sectionBean);

    void onFail(String msg);
}
