package com.year2018.concurrency.chapter08;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Author: zyh
 * Date: 2018/11/9 9:15
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<String>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "record by A";// A录入银行流水数据
                    exgr.exchange(A);
                } catch (InterruptedException e) {
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "record by B";// B录入银行流水数据
                    String A = exgr.exchange("B");
                    System.out.println("A.equals(B):" + A.equals(B) + ",A:" + A + ",B:" + B);
                } catch (InterruptedException e) {
                }
            }
        });

        threadPool.shutdown();
    }
}
