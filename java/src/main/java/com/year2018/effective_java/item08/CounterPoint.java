package com.year2018.effective_java.item08;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: zyh
 * Date: 2018/10/18 20:10
 */
public class CounterPoint extends Point {
    private static final AtomicInteger counter = new AtomicInteger();

    public CounterPoint(int x, int y) {
        super(x, y);
        //让它的构造器记录创建了多少个实例
        counter.incrementAndGet();
    }

    public int numberCreated() {
        return counter.get();
    }
}
