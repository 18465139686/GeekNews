package com.example.greeknews.base;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Lenovo on 2019/4/3.
 */

public  abstract class BasePresenter<V extends BaseView> {
    protected V mView;
    protected ArrayList<BaseModel> mModel=new ArrayList<>();

    public BasePresenter() {
        initModel();
    }

    protected abstract void initModel();


    public void bind(V view) {
        this.mView=view;
    }


    public void onDestory(){
        mView=null;
        if (mModel.size()>0){
            for (BaseModel model:mModel){
                model.onDestory();
            }
        }
    }


}
