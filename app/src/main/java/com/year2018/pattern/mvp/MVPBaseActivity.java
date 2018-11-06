package com.year2018.pattern.mvp;

import android.os.Bundle;

import com.year2018.pattern.mvp.presenter.BasePresenter;

/**
 * Author: zyh
 * Date: 2018/8/29 17:16
 */
public abstract class MVPBaseActivity<T extends BasePresenter> extends BaseActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
}
