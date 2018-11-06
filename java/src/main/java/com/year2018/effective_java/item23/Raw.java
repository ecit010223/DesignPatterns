package com.year2018.effective_java.item23;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Author: zyh
 * Date: 2018/10/24 10:42
 */
public class Raw {
    // Uses raw type (List) - fails at runtime! - Page 112
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        unsafeAdd(strings, new Integer(42));
        String s = strings.get(0); // Compiler-generated cast
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    // Use of raw type for unknown element type - don't do this! - Page 113
    static int rawNumElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }

    // 无限制的通配符类型
    // 如果要使用泛型，但不确定或者不关心实际的类型参数，可以使用一个问号代替
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }
}
