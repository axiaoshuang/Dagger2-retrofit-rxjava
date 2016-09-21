package com.example.litiancheng.dagger2retrofitrxjava.dagger;

import com.example.litiancheng.dagger2retrofitrxjava.ui.MainContract;
import com.example.litiancheng.dagger2retrofitrxjava.ui.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by litiancheng on 16/9/21.
 */
@Module
public class MainActivityModule {
    private MainContract.View view;

    public MainActivityModule(MainContract.View view){
        this.view = view;
    }

    @Provides
    MainPresenter provideMainActivityPresenter(MainContract.View view) {
        return new MainPresenter(view);
    }

    @Provides
    MainContract.View provideMainActivityView(){
        return view;
    }

}
