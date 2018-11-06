package com.year2018.effective_java.item41;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author: zyh
 * Date: 2018/11/1 9:58
 * 会打印“Unknown Collection”三次。因为classify方法被重载了，而要调用哪个重载方法是在编译时做出决定的
 * （对于被覆盖方法的选择是在运行时决定的），对于for循环中的全部三次迭代，参数的编译时类型都是相同的：
 * Collection<?>，每次迭代的运行时类型都是不同的，但这并不影响重载方法的选择。因为该参数的编译时类型为
 * Collection<?>，所以，唯一合适的重载方法是第三个：classify(Collection<?>)，在循环的每次迭代中，都会
 * 调用这个重载方法。
 */
public class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = { new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values() };

        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}
