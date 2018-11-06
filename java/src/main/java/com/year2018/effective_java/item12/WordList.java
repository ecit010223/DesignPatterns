package com.year2018.effective_java.item12;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Author: zyh
 * Date: 2018/10/19 14:26
 */
public class WordList {
    public static void main(String[] args) {
        Set<String> s = new TreeSet<String>();
        Collections.addAll(s, args);
        System.out.println(s);
    }
}
