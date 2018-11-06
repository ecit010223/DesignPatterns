package com.year2018.pattern.image_loader.cache;

import android.graphics.Bitmap;

import com.year2018.pattern.image_loader.request.BitmapRequest;

/**
 * author：zyh
 * on: 2018/8/1 20:26
 *
 * 图片缓存抽象类,具体的子类有不使用缓存{@see NoCache}、内存缓存{@see MemoryCache}、sd卡缓存{@see
 * DiskCache}以及内存和sd卡双缓存{@see DoubleCache}
 */
public interface BitmapCache {
    public Bitmap get(BitmapRequest request);

    public void put(BitmapRequest request, Bitmap value);

    public void remove(BitmapRequest request);
}
