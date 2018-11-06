package com.year2018.pattern.iterator;

/**
 * author：zyh
 * on: 2018/8/21 21:18
 */
public interface Iterator<T> {
    /**
     * 是否还有下一个元素
     * @return true表示有，false表示没有
     */
    boolean hasNext();

    /**
     * 返回当前位置的元素并将位置移到下一位
     * @return
     */
    T next();
}
