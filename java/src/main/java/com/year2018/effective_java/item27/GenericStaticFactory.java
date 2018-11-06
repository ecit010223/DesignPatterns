package com.year2018.effective_java.item27;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: zyh
 * Date: 2018/10/24 14:46
 */
public class GenericStaticFactory {
    // Generic static factory method
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    public static void main(String[] args) {
        // Parameterized type instance creation with static factory
        Map<String, List<String>> anagrams = newHashMap();
    }
}
