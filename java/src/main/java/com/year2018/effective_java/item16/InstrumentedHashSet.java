package com.year2018.effective_java.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Author: zyh
 * Date: 2018/10/20 11:08
 * Broken - Inappropriate use of inheritance!
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<String>();
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        // 实际输出不为3，而是6。
        // addAll方法首先给addCount增加3，然后利用supper.addAll来调用HashSet的addAll实现。然后又依次
        // 调用到被InstrumentedHashSet覆盖了的add方法，每个元素调用一次，这三次调用又分别给addCount加
        // 了1，所以，总共增加了6：通过addAll方法增加的每个元素被计算了两次。
        System.out.println(s.getAddCount());
    }
}
