package com.example.greeknews.presenter.zhihu;

import com.example.greeknews.base.BasePresenter;
import com.example.greeknews.bean.zhihu.SectionBean;
import com.example.greeknews.collback.zhihu.SectionCollBack;
import com.example.greeknews.model.zhihu.SectionM;
import com.example.greeknews.view.zhihu.SectionsV;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class SectionsP extends BasePresenter<SectionsV> implements SectionCollBack{

    private SectionM sectionM;

    @Override
    protected void initModel() {
        sectionM = new SectionM();
        mModel.add(sectionM);
    }

    public void getSectData() {
      sectionM.getSection(this);
    }

    @Override
    public void onSuccess(SectionBean sectionBean) {
        if (mView!=null){
            mView.onSuccess(sectionBean);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mView!=null){
            mView.onFail(msg);
        }
    }
}
