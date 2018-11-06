package com.year2018.pattern.mvp.presenter;

import com.year2018.pattern.mvp.ViewInterface;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Author: zyh
 * Date: 2018/8/29 17:17
 */
public abstract class BasePresenter<V extends ViewInterface> {
    /** view接口类型的弱引用 **/
    protected Reference<V> mViewRef;

    /** 与该Presenter相关联的View **/
    protected V mView;

    public BasePresenter(V view){
        this.attachView(view);
        this.mView = getView();
    }

    /** 与对应的UI建立关联 **/
    public void attachView(V view){
        mViewRef = new WeakReference<>(view);
    }

    /** 获取弱引用的View **/
    public V getView(){
        return mViewRef.get();
    }

    /** 判断View是否还引用，有可能内存不够时被释放 **/
    public boolean isViewAttached(){
        return mViewRef != null&&mViewRef.get() != null;
    }

    /** 释放弱引用的View **/
    public void detachView(){
        if(mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
