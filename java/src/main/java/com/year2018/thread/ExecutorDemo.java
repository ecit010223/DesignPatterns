package com.year2018.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 作者：张玉辉 on 2018/4/22 21:08.
 * 一些已有的执行器可以帮我们管理Thread对象。无需自己创建与控制Thread对象。比如，不用在代码中编写
 * new Thread或者thread1.start()也一样可以使用多线程。如下：
 * exec使用了线程池1中的5个线程做了这几个任务。
 * 这个例子中exec这个Executor负责管理任务，所谓的任务在这里就是实现了Runnable接口的匿名内部类。
 * 至于要使用几个线程，什么时候启动这些线程，是用线程池还是用单个线程来完成这些任务，我们无需操心。
 * 完全由exec这个执行器来负责。在这里exec(new CachedThreadPool)指向是一个可以根据需求创建新线程
 * 的线程池。
 * Executors相当于执行器的工厂类，包含各种常用执行器的工厂方法，可以直接创建常用的执行器。
 * 几种常用的执行器如下：
 * 1.Executors.newCachedThreadPool,根据需要可以创建新线程的线程池。线程池中曾经创建的线程，
 *   在完成某个任务后也许会被用来完成另外一项任务。
 * 2.Executors.newFixedThreadPool(int nThreads),创建一个可重用固定线程数的线程池。
 *   这个线程池里最多包含nThread个线程。
 * 3.Executors.newSingleThreadExecutor(),创建一个使用单个worker线程的Executor。
 *   即使任务再多，也只用1个线程完成任务。
 * 4.Executors.newSingleThreadScheduledExecutor(),创建一个单线程执行程序，它可安排在给定延
 *   迟后运行命令或者定期执行。
 */
public class ExecutorDemo {
    public static void main(String args[]){
//        analyzeNewCachedThreadPool();
        analyzeNewSingleThreadExecutor();
    }

    public static void analyzeNewCachedThreadPool(){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {//5个任务
            exec.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" doing task");
                }
            });
        }
        exec.shutdown();  //关闭线程池
    }

    /** 虽然有5个任务(5个new Runnable)，但是只由1个线程来完成。**/
    public static void analyzeNewSingleThreadExecutor(){
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Runnable() {//execute方法接收Runnable对象，无返回值
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        exec.shutdown();
    }
}
