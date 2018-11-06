package com.year2018.pattern.image_loader.policy;

import com.year2018.pattern.image_loader.request.BitmapRequest;

/**
 * author：zyh
 * on: 2018/8/1 20:49
 * 逆序加载策略,即从最后加入队列的请求进行加载
 */
public class ReversePolicy implements LoadPolicy {
    @Override
    public int compare(BitmapRequest request1, BitmapRequest request2) {
        // 注意Bitmap请求要先执行最晚加入队列的请求,ImageLoader的策略
        return request2.serialNum - request1.serialNum;
    }
}
