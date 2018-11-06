package com.year2018.effective_java.item06;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Author: zyh
 * Date: 2018/10/18 15:08
 * 该程序出现了内存泄漏，程序会越来越慢，如果一个栈先是增长，然后再收缩，那么，从栈中弹出来的对象将不会被
 * 当作垃圾回收，即使使用栈的程序不再引用这些对象，它们也不会被回收。这是因为，栈内部维护着对这些对象的过
 * 期引用，所谓过期引用是指永远也不会再被解除除的引用。
 * 修改方法：一旦引用过期，只需清空这些引用即可。
 * 如下的实例修改：elements[size] = null;
 * 何时应该清空引用：问题在于，Stack类自己管理内存，存储池包含了elements数组（对象引用单元，而不是对象
 * 本身）的元素。数组活动区域中（前面定义）的元素是已分配的，而数组其余部分的元素则是自由的，但是垃圾回
 * 收器并不知道这一点；对于垃圾回收器而言，elements数组中的所有对象引用都同等有效。只有程序员知道数组的
 * 非活动部分是不重要的，程序员可以把这个情况告知垃圾回收器，做法很简单：一旦数组元素变成了非活动部分的
 * 一部分，程序员就手工清空这些数组元素。
 * 一般而言，只要类是自己管理内存，程序员就应该警惕内存泄漏问题，一旦元素被释放掉，则该元素中包含的任何
 * 对象引用都应该被清空。
 * 内存泄漏的另一个常见来源是缓存：如果正好要实现这样的缓存：只要在缓存之外存在对某个项的引用，该项就有
 * 意义，那么就可以WeakHashMap代表缓存；当缓存中的项过期后，它们就会自动被删除。记住只有当所要的缓存项
 * 的生命同期是由该键的外部引用而不是由值决定时，WeakHashMap才有用处。更为常见的情形则是，“缓存项的生
 * 命周期是否有意义”并不是很容易确定，随着时间的推移，其中的项会变得越来越没坐标。在这种情况下，缓存应
 * 该时不时的清除掉没用的项。这项清除工作可以由一个后台线程（可能是Timer或者ScheduledThreadPoolExecutor）
 * 来完成，或者也可以在给缓存添加新条目的时候顺便进行清理。LinkedHashMap类利用它的removeEldestEntry方
 * 法可以很容易地实现后一种方案。对于更加复杂的缓存，必须直接使用java.lang.ref
 * 内存泄漏的第三个常见来源是监听器和其它回调，如果实现了一个API，客户在这个API注册回调，却没有显式地取
 * 消注册，那么除非你采取某些动作，否则它们就会积聚。确保回调立即被当作垃圾回收的最佳方法是只保存它们的
 * 弱引用（weak reference），例如，只将它们保存成WeakHashMap中的键
 * 分析工作：Heap Profile
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();
        return elements[--size];
    }

    /**
     * Ensure space for at least one more element, roughly doubling the capacity
     * each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
