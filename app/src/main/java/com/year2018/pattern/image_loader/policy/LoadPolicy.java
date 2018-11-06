package com.year2018.pattern.image_loader.policy;

import com.year2018.pattern.image_loader.request.BitmapRequest;

/**
 * author：zyh
 * on: 2018/8/1 20:48
 * 加载策略接口
 */
public interface LoadPolicy {
    public int compare(BitmapRequest request1, BitmapRequest request2);
}
