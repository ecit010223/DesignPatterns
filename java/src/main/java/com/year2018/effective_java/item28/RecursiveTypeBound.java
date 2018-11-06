package com.year2018.effective_java.item28;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Author: zyh
 * Date: 2018/10/24 15:44
 */
public class RecursiveTypeBound {
    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        Iterator<? extends T> i = list.iterator();
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
