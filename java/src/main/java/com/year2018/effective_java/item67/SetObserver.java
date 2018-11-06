package com.year2018.effective_java.item67;

/**
 * Author: zyh
 * Date: 2018/11/6 9:17
 * 观察者
 */
public interface SetObserver<E> {
    // Invoked when an element is added to the observable set
    void added(ObservableSet<E> set, E element);
}
