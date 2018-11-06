package com.year2018.pattern.iterator.advance;

/**
 * author：zyh
 * on: 2018/8/21 22:21
 */
public class HuiIterator implements Iterator {
    private Employee[] array;
    private int position;

    public HuiIterator(Employee[] array){
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return !(position>array.length-1||array[position]==null);
    }

    @Override
    public Object next() {
        Employee e = array[position];
        position++;
        return e;
    }
}
