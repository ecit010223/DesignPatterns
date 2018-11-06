package com.year2018.effective_java.item11;

import java.util.Arrays;

/**
 * Author: zyh
 * Date: 2018/10/19 13:30
 */
public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 域包含了可变的对象，因此还需对可变对象进行克隆。
     * 如未对elements进行克隆，它的elements域将引用与原始Stack实例相同的数组。
     * @return
     */
    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            //自1.5发行版本起，在数组上调用clone返回的数组，其编译时类型与克隆数组的类型相同
            //如果elements是final的，则无法克隆，因为clone方法是被禁止给elements域赋新值的
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    // Ensure space for at least one more element.
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // To see that clone works, call with several command line arguments
    public static void main(String[] args) {
        Stack stack = new Stack();
        for (String arg : args)
            stack.push(arg);
        Stack copy = stack.clone();
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
        while (!copy.isEmpty())
            System.out.print(copy.pop() + " ");
    }
}
