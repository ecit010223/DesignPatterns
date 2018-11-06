package com.year2018.pattern.iterator;

/**
 * author：zyh
 * on: 2018/8/21 21:22
 * 窗口接口
 */
public interface Aggregate<T> {
    /**
     * 添加一个元素
     * @param obj
     */
    void add(T obj);

    /**
     * 移除一个元素
     * @param obj
     */
    void remove(T obj);

    /**
     * 获取容器的迭代器
     * @return 迭代器对象
     */
    Iterator<T> iterator();
}
