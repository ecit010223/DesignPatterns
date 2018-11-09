package com.year2018.concurrency.chapter07;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Author: zyh
 * Date: 2018/11/9 9:12
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1, 2};

    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0, 3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }
}
