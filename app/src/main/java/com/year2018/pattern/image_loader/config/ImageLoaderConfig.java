package com.year2018.pattern.image_loader.config;

import com.year2018.pattern.image_loader.cache.BitmapCache;
import com.year2018.pattern.image_loader.cache.MemoryCache;
import com.year2018.pattern.image_loader.policy.LoadPolicy;
import com.year2018.pattern.image_loader.policy.SerialPolicy;

/**
 * author：zyh
 * on: 2018/8/1 20:37
 * ImageLoader配置类
 */
public class ImageLoaderConfig {
    /**
     * 图片缓存配置对象
     */
    public BitmapCache bitmapCache = new MemoryCache();

    /**
     * 加载图片时的loading和加载失败的图片配置对象
     */
    public DisplayConfig displayConfig = new DisplayConfig();
    /**
     * 加载策略
     */
    public LoadPolicy loadPolicy = new SerialPolicy();

    /**
     *
     */
    public int threadCount = Runtime.getRuntime().availableProcessors() + 1;

    /**
     * @param count
     * @return
     */
    public ImageLoaderConfig setThreadCount(int count) {
        threadCount = Math.max(1, count);
        return this;
    }

    public ImageLoaderConfig setCache(BitmapCache cache) {
        bitmapCache = cache;
        return this;
    }

    public ImageLoaderConfig setLoadingPlaceholder(int resId) {
        displayConfig.loadingResId = resId;
        return this;
    }

    public ImageLoaderConfig setNotFoundPlaceholder(int resId) {
        displayConfig.failedResId = resId;
        return this;
    }

    public ImageLoaderConfig setLoadPolicy(LoadPolicy policy) {
        if (policy != null) {
            loadPolicy = policy;
        }
        return this;
    }
}
