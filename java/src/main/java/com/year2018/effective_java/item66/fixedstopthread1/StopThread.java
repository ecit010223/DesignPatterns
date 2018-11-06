package com.year2018.effective_java.item66.fixedstopthread1;

import java.util.concurrent.TimeUnit;

/**
 * Author: zyh
 * Date: 2018/11/5 16:38
 * 注意写方法（requestStop）读方法（stopRequest）都被同步了。只同步写方法还不够！实际上，如果读和写操作
 * 没有都被同步，同步就不会起作用。
 * StopThread中被同步方法的动作即使没有同步也是原子，换句话说，这些方法的同步只是为了它的通信效果，而不是
 * 为了互斥访问，虽然循环的每个迭代中的同步开销很小，还是有其它更正确的替代方法，它更加简洁，性能也可以更
 * 好。见fixedstopthread2包，将stopRequested声明为volatile
 */
public class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {
            public void run() {
                int i = 0;
                while (!stopRequested())
                    i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
