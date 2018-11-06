package com.year2018.thread;

/**
 * 作者：张玉辉 on 2018/4/22 21:17.
 * 我们应该使用现有Executor或ExecutorService实现类。比如前面说的newCachedThreadPool可以使用线程池帮
 * 我们降低开销（创建一个新的线程是有一定代价的），而newFixedThreadPool则可以限制并发线程数。即，
 * 我们一般使用Executors的工厂方法来创建我们需要的执行器。
 *
 */
public class ExecutorAndExecutorService {

    public static void main(String args[]){
    }

    /**
     * Executor接口只有void execute(Runnable command)方法,从方法声明中可以看到入参为Runnable类型对象。
     * 但里面具体怎么执行，是否调用线程执行由相应的Executor接口实现类决定。比如前面的newCachedThreadPool
     * 使用线程池来进行执行。Executor将任务提交与每个任务如何运行（如何使用线程、调度）相分离。
     */
    public static void executeFunction(){
//        Executor executor = anExecutor;
//        executor.execute(new RunnableTask1());
    }

    /**
     * ExecutorService接口继承自Executor接口，扩展了父接口中的execute方法。
     * 有两个常用的submit方法:
     * 可以看到这两个常用方法一个接收Runnable类型入参，一个接收Callable类型入参。Callable入参允许任务返
     * 回值，而Runnable无返回值。也就是说如果我们希望线程有一个返回结果，我们应该使用Callable类型入参。
     */
    public static void submitFunction(){
//        Future<?> submit(Runnable task)
//        <T> Future<T> submit(Callable<T> task)
    }

    /**
     * 批量执行一组Callable任务。其中invokeAll是等所有任务完成后返回代表结果的Future列表。而invokeAny是
     * 等这一批任务中的任何一个任务完成后就返回。从两个方法的返回结果我们也可以看出两个方法的不同.
     */
    public static void invokeAllAndInvokeAny(){
//        <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks
//        <T> T invokeAny(Collection<? extends Callable<T>> tasks)
    }

    /**
     * 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。执行此方法后，线程池等待任务结束后就关闭，
     * 同时不再接收新的任务。如果执行完shutdown()方法后，再去执行execute方法则直接抛出
     * RejectedExecutionException。
     * 原则：只要ExecutorService(线程池)不再使用，就应该关闭，以回收资源。要注意这个不再使用。
     */
    public static void shutdownFunction(){

    }
}
