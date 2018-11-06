package com.year2018.pattern.iterator.advance;

import java.util.List;

/**
 * author：zyh
 * on: 2018/8/21 22:10
 */
public class MinIterator implements Iterator {
    private List<Employee> list;
    private int position;

    public MinIterator(List<Employee> list){
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return !(position>list.size()-1||list.get(position)==null);
    }

    @Override
    public Object next() {
        Employee e = list.get(position);
        position++;
        return e;
    }
}
