package com.year2018.type.bean;

import java.util.List;

/**
 * 作者：张玉辉 on 2018/4/22 15:20.
 * extends用来指定上边界，没有指定的话上边界默认是Object，super用来指定下边界，没有指定的话为null
 */
public class WildcardTypeBean {
    // a没有下界
    private List<? extends Number> a;
    //  没有指定的话，上边界默认是 Object ,下边界是  String
    private List<? super String> b;
    private List<String> c;
    private Class<?> aClass;
}
