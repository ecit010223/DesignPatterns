package com.year2018.effective_java.item66.brokenstopthread;

import java.util.concurrent.TimeUnit;

/**
 * Author: zyh
 * Date: 2018/11/5 16:37
 * 由于boolean域的读和写操作都是原子的，程序员在访问这个域的时候不再使用同步。
 * 程序的目的：程序运行大约一秒针左右，之后主线程将stopRequested设置为true，致使后台线程的循环终止，但程
 * 序永远不会终止：因为后台线程永远在循环。
 * 问题在于：由于没有同步，就不能保证后台线程何时“看到”主线程对stopRequested的值所做的改变，没有同步，虚
 * 拟机将代码：
 * while(!done)
 *     i++;
 * 转变成：
 * if(!done)
 *     while(true)
 *         i++;
 * 这是可以接受的，这种优化称作提升，正是HopSpot Server VM的工作。结果是个活性失败：这个程序无法前进，修
 * 正这个问题的一种方式是同步访问stopRequested域，见fixedstopthread1包中的程序。
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested)
                    i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
