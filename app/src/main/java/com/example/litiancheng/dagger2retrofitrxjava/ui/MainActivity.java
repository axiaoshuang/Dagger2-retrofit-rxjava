package com.example.litiancheng.dagger2retrofitrxjava.ui;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.litiancheng.dagger2retrofitrxjava.R;
import com.example.litiancheng.dagger2retrofitrxjava.base.BaseActivity;
import com.example.litiancheng.dagger2retrofitrxjava.dagger.AppComponent;
import com.example.litiancheng.dagger2retrofitrxjava.dagger.DaggerMainActivyComponet;
import com.example.litiancheng.dagger2retrofitrxjava.dagger.MainActivityModule;
import com.example.litiancheng.dagger2retrofitrxjava.net.ApiModule;
import com.example.litiancheng.dagger2retrofitrxjava.net.ApiSevices;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Response;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * dagger框架+rxjava+retrofit组合使用
 */
public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject
    MainPresenter mMainPresenter;
    @Bind(R.id.main_tv)
    TextView mMainTv;
    private Dialog mDialog;


    @Override
    public int getView() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        //初始化dialog
        initDialog();


    }

    /**
     * dagger绑定
     */
    @Override
    protected void setupActivityComponent() {
        DaggerMainActivyComponet.builder()
                                .mainActivityModule(new MainActivityModule(this))
                                .build()
                                .bind(this);
    }

    /**
     * dialog初始化
     */
    private void initDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.layout_loading_dialog, null); // 得到加载view
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view); // 加载布局
        mDialog = new Dialog(this, R.style.loading_dialog); // 创建自定义样式dialog
        mDialog.setCancelable(false); // 不可以用"返回键"取消
        mDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void showDialog() {
        mDialog.show();
    }

    @Override
    public void hideDialog() {
        mDialog.dismiss();
    }

    @Override
    public void showContent(String s) {
        mMainTv.setText(s);
    }

    /**
     * 按钮点击事件
     *
     * @param view
     */
    public void getData(View view) {
        mMainPresenter.getContent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.onDestroy();

    }
}
