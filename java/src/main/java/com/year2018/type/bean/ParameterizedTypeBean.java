package com.year2018.type.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 作者：张玉辉 on 2018/4/22 11:02.
 */
public class ParameterizedTypeBean {
    // 下面的 field 的 Type 属于 ParameterizedTypeBean
    Map<String, Person> map;
    Set<String> set1;
    Class<?> clz;
    Holder<String> holder;
    List<String> list;
    // Map<String,Person> map 这个 ParameterizedTypeBean 的 getOwnerType() 为 null，
    // 而 Map.Entry<String, String> entry 的 getOwnerType() 为 Map 所属于的 Type。
    Map.Entry<String, String> entry;

    // 下面的 field 的 Type 不属于ParameterizedType
    String str;
    Integer i;
    Set set;
    List aList;

    static class Holder<V> {

    }
}
