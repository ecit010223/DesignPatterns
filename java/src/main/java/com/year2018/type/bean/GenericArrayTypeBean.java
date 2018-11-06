package com.year2018.type.bean;

import java.util.List;

/**
 * 作者：张玉辉 on 2018/4/22 15:14.
 * // 属于 GenericArrayType
 * List<String>[] pTypeArray;
 * // 属于 GenericArrayType
 * T[] vTypeArray;
 * // 不属于 GenericArrayType
 * List<String> list;
 * // 不属于 GenericArrayType
 * String[] strings;
 * // 不属于 GenericArrayType
 * Person[] ints;
 */
public class GenericArrayTypeBean<T> {
    public void test(List<String>[] pTypeArray,
                     T[] vTypeArray,
                     List<String> list,
                     String[] strings,
                     Person[] ints) {
    }
}
