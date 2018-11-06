package com.year2018.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 作者：张玉辉 on 2018/4/22 22:05.
 * FutureTask类是 Future 接口的一个实现。FutureTask类实现了RunnableFuture接口，
 * RunnableFuture继承了Runnable接口和Future接口，所以：
 * 1.FutureTask可以作为Runnable被线程执行
 * 2.可以作为Future得到传入的Callable对象的返回值
 * FutureTask<Integer> futureTask = new FutureTask<>(new Callable...)相当于把Callable任务转换为
 * Runnable任务，就可以使用线程来执行该任务。而futureTask.get()相当于将Callable转化为Future，
 * 从而得到异步运算的结果。
 */
public class FutureTaskDemo {
    public static void main(String args[]){

    }

    /** ExecutorService执行器除了接收Runnable与Callable类型的入参，也可以接收FutureTask类型 **/
    public static void complex(){
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("futureTask is wokring 1+1!");
                TimeUnit.SECONDS.sleep(2);
                return 2;
            }
        });
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(futureTask);//也可以使用execute，证明其是一个Runnable类型对象
        executor.shutdown();
        while(!futureTask.isDone()){
            System.out.println("thread is not finished");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("thread run result："+futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void simple(){
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("futureTask is wokring 1+1!");
                return 2;
            }
        });
        Thread t1 = new Thread(futureTask);//1.可以作为Runnable类型对象使用
        t1.start();
        try {
            try {
                System.out.println(futureTask.get());//2.可以作为Future类型对象得到线程运算返回值
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
