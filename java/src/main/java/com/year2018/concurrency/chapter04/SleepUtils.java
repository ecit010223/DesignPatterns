package com.year2018.concurrency.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Author: zyh
 * Date: 2018/11/9 8:55
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
