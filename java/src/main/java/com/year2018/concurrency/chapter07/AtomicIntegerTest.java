package com.year2018.concurrency.chapter07;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: zyh
 * Date: 2018/11/9 9:13
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
