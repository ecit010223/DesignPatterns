package com.year2018.pattern;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.year2018.pattern.mvp.MVPBaseActivity;
import com.year2018.pattern.mvp.ViewInterface;
import com.year2018.pattern.mvp.presenter.MainPresenter;

/**
 * Author: zyh
 * Date: 2018/8/3 9:26
 */
public class MainActivity extends MVPBaseActivity<MainPresenter> implements ViewInterface<String> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void fetchDataFinished(int tag, String result) {

    }

    @Override
    public void fetchDataFailure(int tag, String failure) {

    }
}
