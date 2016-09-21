package com.example.litiancheng.dagger2retrofitrxjava.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by litiancheng on 16/9/21.
 */

@Module
public class AppModule {
    private Application application;

    public AppModule(Application application){
        this.application=application;
    }

    @Provides
    public Application provideApplication(){
        return application;
    }

}
