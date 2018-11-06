package com.year2018.pattern.image_loader.cache;

import android.graphics.Bitmap;

import com.year2018.pattern.image_loader.request.BitmapRequest;

/**
 * author：zyh
 * on: 2018/8/1 20:36
 * 没有缓存
 */
public class NoCache implements BitmapCache {
    @Override
    public Bitmap get(BitmapRequest request) {
        return null;
    }

    @Override
    public void put(BitmapRequest request, Bitmap value) {

    }

    @Override
    public void remove(BitmapRequest request) {

    }
}
