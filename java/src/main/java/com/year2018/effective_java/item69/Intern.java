package com.year2018.effective_java.item69;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Author: zyh
 * Date: 2018/11/6 11:18
 */
public class Intern {
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    // Concurrent canonicalizing map atop ConcurrentMap - not optimal - Page 273
//    public static String intern(String s) {
//        String previousValue = map.putIfAbsent(s, s);
//        return previousValue == null ? s : previousValue;
//    }

    // Concurrent canonicalizing map atop ConcurrentMap - faster! - Page 274
    public static String intern(String s) {
        String result = map.get(s);
        if (result == null) {
            result = map.putIfAbsent(s, s);
            if (result == null)
                result = s;
        }
        return result;
    }
}
