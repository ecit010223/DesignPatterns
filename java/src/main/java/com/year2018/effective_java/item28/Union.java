package com.year2018.effective_java.item28;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: zyh
 * Date: 2018/10/24 15:42
 */
public class Union {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<E>(s1);
        result.addAll(s2);
        return result;
    }

    // Simple program to exercise flexible generic method
    public static void main(String[] args) {
        Set<Integer> integers = new HashSet<Integer>();
        integers.add(1);
        integers.add(3);
        integers.add(5);

        Set<Double> doubles = new HashSet<Double>();
        doubles.add(2.0);
        doubles.add(4.0);
        doubles.add(6.0);

        // Won't compile; see page 137
        // Set<Number> numbers = union(integers, doubles);

        // 如果没有添加显式的类型参数<Number>，编译将出错
        Set<Number> numbers = Union.<Number> union(integers, doubles);

        System.out.println(numbers);
    }
}
