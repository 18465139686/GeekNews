package com.example.greeknews.view.zhihu;

import com.example.greeknews.base.BaseView;
import com.example.greeknews.bean.zhihu.SectionBean;

/**
 * Created by Lenovo on 2019/4/17.
 */

public interface SectionsV extends BaseView{
    void onSuccess(SectionBean sectionBean);

    void onFail(String msg);
}
