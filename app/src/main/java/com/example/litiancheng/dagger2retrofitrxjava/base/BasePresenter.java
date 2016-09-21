package com.example.litiancheng.dagger2retrofitrxjava.base;

import com.example.litiancheng.dagger2retrofitrxjava.dagger.AppComponent;
import com.example.litiancheng.dagger2retrofitrxjava.net.ApiModule;
import com.example.litiancheng.dagger2retrofitrxjava.net.ApiSevices;

import javax.inject.Inject;

/**
 * Created by litiancheng on 16/9/20.
 */

public abstract class BasePresenter {
    @Inject
    protected ApiSevices mApiModule;
    public BasePresenter() {
        setupActivityComponent(BaseApplication.getInstance().getAppComponent());
    }


    protected void setupActivityComponent(AppComponent appComponent) {
            appComponent.bind(this);
    }
    public abstract void onDestroy();
}
