package com.year2018.concurrency.chapter05;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: zyh
 * Date: 2018/11/9 9:00
 * 与synchronized不同，获取到锁的线程能够响应中断，当获取到锁的线程被中继时，中断异常将会被抛出，
 * 同时锁会被释放。
 */
public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    // 获取等待通知组件，该组件和当前的锁绑定，当前线程只有获得了锁，才能调用该组件的wait()方法，
    // 而调用后，当前线程将释放锁。
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException {
        lock.lock();
        try {
            condition.await();
        } finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException {
        lock.lock();
        try {
            // 其他线程调用Condition对象的signal()方法，通知当前线程后，
            // 当前线程才从await()方法返回，并且在返回前已经获取了锁
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
