package com.year2018.concurrency.chapter03;

/**
 * Author: zyh
 * Date: 2018/11/9 8:38
 */
public class SafeLazyInitialization {
    private static Instance instance;

    public synchronized static Instance getInstance() {
        if (instance == null)
            instance = new Instance();
        return instance;
    }

    static class Instance {
    }
}
