package com.example.litiancheng.dagger2retrofitrxjava.dagger;

import com.example.litiancheng.dagger2retrofitrxjava.base.BasePresenter;
import com.example.litiancheng.dagger2retrofitrxjava.net.ApiModule;
import com.example.litiancheng.dagger2retrofitrxjava.ui.MainActivity;

import dagger.Component;

/**
 * Created by litiancheng on 16/9/21.
 */
@Component(modules = {  ApiModule.class})
public interface AppComponent {
    void bind(BasePresenter presenter);
}
