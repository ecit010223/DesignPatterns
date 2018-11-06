package com.year2018.pattern.image_loader.cache;

import android.content.Context;
import android.graphics.Bitmap;

import com.year2018.pattern.image_loader.request.BitmapRequest;

/**
 * author：zyh
 * on: 2018/8/1 20:33
 * 综合缓存,内存和sd卡双缓存
 */
public class DoubleCache implements BitmapCache {
    DiskCache mDiskCache;

    MemoryCache mMemoryCache = new MemoryCache();

    public DoubleCache(Context context) {
        mDiskCache = DiskCache.getDiskCache(context);
    }

    @Override
    public Bitmap get(BitmapRequest request) {
        Bitmap value = mMemoryCache.get(request);
        if (value == null) {
            value = mDiskCache.get(request);
            saveBitmapIntoMemory(request, value);
        }
        return value;
    }

    private void saveBitmapIntoMemory(BitmapRequest request, Bitmap bitmap) {
        // 如果Value从disk中读取,那么存入内存缓存
        if (bitmap != null) {
            mMemoryCache.put(request, bitmap);
        }
    }

    @Override
    public void put(BitmapRequest request, Bitmap value) {
        mDiskCache.put(request, value);
        mMemoryCache.put(request, value);
    }

    @Override
    public void remove(BitmapRequest request) {
        mDiskCache.remove(request);
        mMemoryCache.remove(request);
    }
}
