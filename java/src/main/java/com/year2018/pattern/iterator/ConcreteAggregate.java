package com.year2018.pattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * author：zyh
 * on: 2018/8/21 21:25
 */
public class ConcreteAggregate<T> implements Aggregate<T> {
    private List<T> list = new ArrayList<T>();

    @Override
    public void add(T obj) {
        list.add(obj);
    }

    @Override
    public void remove(T obj) {
        list.remove(obj);
    }

    @Override
    public Iterator<T> iterator() {
        return new ConcreteIterator<T>(list);
    }
}
