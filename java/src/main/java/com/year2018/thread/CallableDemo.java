package com.year2018.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 作者：张玉辉 on 2018/4/22 21:31.
 * Callable代表有返回值的任务。
 * Future 表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，并获取计算的结果。
 * get方法：等待计算完成，然后获取其结果。
 * isDone方法：用来查询任务是否做完
 */
public class CallableDemo {
    public static void main(String args[]){
        isDoneDemo();
    }

    public static void isDoneDemo(){
        /*新建一个Callable任务*/
        Callable<Integer> callableTask = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Calculating 1+1!");
                TimeUnit.SECONDS.sleep(2);//休眠2秒
                return 2;
            }
        };
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(callableTask);
        executor.shutdown();
        while(!result.isDone()){//isDone()方法可以查询子线程是否做完
            System.out.println("thread is running...");
            try {
                TimeUnit.SECONDS.sleep(1);//休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            System.out.println("thread run result:"+result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void callableDemo(){
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Callable<String>> taskList = new ArrayList<Callable<String>>();
        /* 往任务列表中添加5个任务 */
        for (int i = 0; i < 5; i++) {
            taskList.add(new CalcTask());
        }
        /* 结果列表:存放任务完成返回的值 */
        List<Future<String>> resultList = new ArrayList<Future<String>>();
        try {
            /*invokeAll批量运行所有任务, submit提交单个任务*/
            resultList = exec.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            /*从future中输出每个任务的返回值*/
            for (Future<String> future : resultList) {
                System.out.println(future.get());//get方法会阻塞直到结果返回
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    /**
     * 这个任务比较简单，就是返回当前线程的名字。与Runnable相比较有一个返回值，
     * 在这里返回值类型为String，也可以为其他类型。
     */
    static class CalcTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName();
        }
    }
}
