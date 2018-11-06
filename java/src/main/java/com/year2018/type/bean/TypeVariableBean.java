package com.year2018.type.bean;

import java.io.Closeable;
import java.io.InputStream;
import java.util.List;

/**
 * 作者：张玉辉 on 2018/4/22 14:58.
 */
public class TypeVariableBean<K extends InputStream & Closeable, V> {
    // K的上边界是InputStream
    K key;
    // 没有指定的话，V的上边界属于Object
    V value;
    // 不属于TypeVariable
    V[] values;
    String str;
    List<K> kList;
}
