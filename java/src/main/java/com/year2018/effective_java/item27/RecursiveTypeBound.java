package com.year2018.effective_java.item27;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Author: zyh
 * Date: 2018/10/24 14:46
 */
public class RecursiveTypeBound {
    // Returns the maximum value in a list - uses recursive type bound
    public static <T extends Comparable<T>> T max(List<T> list) {
        Iterator<T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0)
                result = t;
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> argList = Arrays.asList(args);
        System.out.println(max(argList));
    }
}
