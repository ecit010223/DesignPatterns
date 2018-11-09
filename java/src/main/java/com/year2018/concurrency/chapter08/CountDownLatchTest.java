package com.year2018.concurrency.chapter08;

import java.util.concurrent.CountDownLatch;

/**
 * Author: zyh
 * Date: 2018/11/9 9:14
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();
        System.out.println("3");
    }
}
