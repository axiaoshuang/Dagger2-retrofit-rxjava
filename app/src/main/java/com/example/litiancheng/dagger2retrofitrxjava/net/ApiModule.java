package com.example.litiancheng.dagger2retrofitrxjava.net;

import android.app.Application;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by litiancheng on 16/9/21.
 */
@Module
public class ApiModule {
    public static final String BASE_URL="http://m2.qiushibaike.com";


    @Provides
    public Retrofit provideRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) // 添加Rx适配器
                .addConverterFactory(ScalarsConverterFactory.create())//string转换器
                .build();
        return retrofit;
    }

    @Provides
    protected ApiSevices provideApiModule(Retrofit retrofit) {

        return retrofit.create(ApiSevices.class);
    }


}
