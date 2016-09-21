package com.example.litiancheng.dagger2retrofitrxjava.base;

import android.app.Application;

import com.example.litiancheng.dagger2retrofitrxjava.dagger.AppComponent;
import com.example.litiancheng.dagger2retrofitrxjava.dagger.AppModule;
import com.example.litiancheng.dagger2retrofitrxjava.dagger.DaggerAppComponent;
import com.example.litiancheng.dagger2retrofitrxjava.net.ApiModule;

import rx.schedulers.NewThreadScheduler;

/**
 * Created by litiancheng on 16/9/20.
 */

public class BaseApplication extends Application {
    private static BaseApplication app;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        setupCompoent();
    }

    public  static  BaseApplication getInstance(){
        return app;
    }

    private void setupCompoent() {
        mAppComponent=DaggerAppComponent.builder()
                            .apiModule(new ApiModule())
                                .build();


    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
