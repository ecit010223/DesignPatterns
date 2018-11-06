package com.year2018.pattern.image_loader.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.year2018.pattern.image_loader.request.BitmapRequest;

/**
 * author：zyh
 * on: 2018/8/1 20:34
 * 图片的内存缓存,key为图片的uri,值为图片本身
 */
public class MemoryCache implements BitmapCache {
    private LruCache<String, Bitmap> mMemeryCache;

    public MemoryCache() {

        // 计算可使用的最大内存
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // 取4分之一的可用内存作为缓存
        final int cacheSize = maxMemory / 4;
        mMemeryCache = new LruCache<String, Bitmap>(cacheSize) {

            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };
    }

    @Override
    public Bitmap get(BitmapRequest request) {
        return mMemeryCache.get(request.imageUri);
    }

    @Override
    public void put(BitmapRequest request, Bitmap value) {
        mMemeryCache.put(request.imageUri, value);
    }

    @Override
    public void remove(BitmapRequest request) {
        mMemeryCache.remove(request.imageUri);
    }
}
