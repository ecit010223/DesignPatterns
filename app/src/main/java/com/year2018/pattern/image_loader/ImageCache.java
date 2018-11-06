package com.year2018.pattern.image_loader;

import android.graphics.Bitmap;

/**
 * author：zyh
 * on: 2018/8/1 20:07
 * ImageCache
 */
public interface ImageCache {
    public Bitmap get(String url);
    public void put(String url,Bitmap bmp);
}
