package com.example.litiancheng.dagger2retrofitrxjava.ui;

import com.example.litiancheng.dagger2retrofitrxjava.base.BasePresenter;
import com.example.litiancheng.dagger2retrofitrxjava.dagger.AppComponent;

import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by litiancheng on 16/9/20.
 */

public class MainPresenter extends BasePresenter implements  MainContract.Persenter {
    private CompositeSubscription mCompositeSubscription;
    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mCompositeSubscription=new CompositeSubscription();
    }



    @Override
    public void onDestroy() {
    mCompositeSubscription.clear();
    }

    @Override
    public void getContent() {
        mView.showDialog();
        mCompositeSubscription.add(
        mApiModule.getContent(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<String>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideDialog();


                    }

                    @Override
                    public void onNext(Response<String> stringResponse) {

                        mView.hideDialog();
                        mView.showContent(stringResponse.body());
                    }
                })

        );

    }
}
