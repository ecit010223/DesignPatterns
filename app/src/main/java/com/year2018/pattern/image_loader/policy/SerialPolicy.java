package com.year2018.pattern.image_loader.policy;

import com.year2018.pattern.image_loader.request.BitmapRequest;

/**
 * author：zyh
 * on: 2018/8/1 20:50
 */
public class SerialPolicy implements LoadPolicy {
    @Override
    public int compare(BitmapRequest request1, BitmapRequest request2) {
        // 如果优先级相等,那么按照添加到队列的序列号顺序来执行
        return request1.serialNum - request2.serialNum;
    }
}
