package com.year2018.effective_java.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Author: zyh
 * Date: 2018/10/20 11:29
 * 包装类：包装类几乎没有什么缺点，但要注意一点，包装类不适合用在回调框架。
 * 在回调框架中，对象把自身的引用传递给其它的对象，用于后续的调用（回调），因为被包装起来的对象并不知道
 * 它外面的包装对象，所以它传递一个指向自身的引用，回调时避开了外面的包装对象。
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
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
        InstrumentedSet<String> s = new InstrumentedSet<String>(
                new HashSet<String>());
        s.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println(s.getAddCount());
    }
}
