package com.example.litiancheng.dagger2retrofitrxjava.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.litiancheng.dagger2retrofitrxjava.dagger.AppComponent;

import butterknife.ButterKnife;

/**
 * Created by litiancheng on 16/9/20.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(getView());
        ButterKnife.bind(this);
        setupActivityComponent();
        initData();


    }
    public abstract int getView();

    public abstract void initData();
    protected abstract void setupActivityComponent( );


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
