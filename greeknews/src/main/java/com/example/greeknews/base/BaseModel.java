package com.example.greeknews.base;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Lenovo on 2019/4/3.
 */

public class BaseModel {
    protected CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    public void onDestory() {
        mCompositeDisposable.clear();
    }
}
