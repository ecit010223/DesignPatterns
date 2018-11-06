package com.year2018.pattern.iterator.advance;

/**
 * author：zyh
 * on: 2018/8/21 22:09
 */
public interface Iterator {
    /**
     * 是否还有下一个元素
     */
    boolean hasNext();

    /**
     * 返回当前位置的元素，并将位置移至下一位
     * @return
     */
    Object next();
}
