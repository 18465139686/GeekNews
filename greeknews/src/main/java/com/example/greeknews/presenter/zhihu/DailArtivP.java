package com.example.greeknews.presenter.zhihu;

import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.base.BasePresenter;
import com.example.greeknews.bean.zhihu.DailArtioBean;
import com.example.greeknews.collback.zhihu.DailArtrvCollBack;
import com.example.greeknews.fragment.zhihu.DailyNewsFragment;
import com.example.greeknews.model.zhihu.DailArtivM;
import com.example.greeknews.view.zhihu.DailArtivV;

/**
 * Created by Lenovo on 2019/4/21.
 */

public class DailArtivP extends BasePresenter<DailArtivV> implements DailArtrvCollBack{

    private final DailArtivM model;

    public DailArtivP(DailArtivV view) {
        model = new DailArtivM();
        mModel.add(model);
    }

    @Override
    protected void initModel() {

    }

    public void getData(String mDate) {
        model.getData(mDate,this);
    }

    @Override
    public void onSuccess(DailArtioBean dailArtio) {
        if (mView!=null){
            mView.onSuccess(dailArtio);
        }
    }
}
