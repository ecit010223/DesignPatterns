package com.year2018.thread;

/**
 * 作者：张玉辉 on 2018/4/22 21:06.
 * 1. 实现Runnable的类应该被看作一项任务，而不是一个线程。在Java多线程中我们一定要有一个明确的理解，
 *    任务和线程是不同的概念。可以使用线程(Thread)执行任务(比如Runnable)，但任务不是线程。
 * 2. Java多线程中有两种不同类型的任务，Runnable类型任务（无返回值）与Callable类型任务(有返回值)。
 */
public class SimpleThread {

    public static void main(String args[]){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t1.start();
    }
}
