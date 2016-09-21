package com.example.litiancheng.dagger2retrofitrxjava.ui;

import com.example.litiancheng.dagger2retrofitrxjava.base.BasePresenter;
import com.example.litiancheng.dagger2retrofitrxjava.base.BaseView;

/**
 * Created by litiancheng on 16/9/20.
 */

public interface MainContract  {
    interface  Persenter {

        void getContent();
    }
    interface  View extends BaseView {
        void showDialog();

        void hideDialog();

        void showContent(String s);
    }
}
