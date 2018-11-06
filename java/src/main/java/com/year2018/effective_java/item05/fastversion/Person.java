package com.year2018.effective_java.item05.fastversion;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Author: zyh
 * Date: 2018/10/18 14:45
 * 如果isBabyBoomer方法被频繁地调用，这种方法将会显著地提高性能。
 * 如果改进后的Person类被初始化了，它的isBabyBoomer方法却永远不会被调用，那就没有必要初始化BOOM_START
 * 和BOOM_END域，通过延迟初始化（见item71），即把对这些域的初始化延迟到isBabyBoomer方法第一次被调用的
 * 时候进行，则有可能消除这些不必要的初始化工作，但是不建议这样做，正如延迟初始化中常见的情况一样，这样
 * 做会使方法的实现更加复杂，从而无法将性能显著提高到超过已经达到的水平。
 */
public class Person {
    private final Date birthDate;

    public Person(Date birthDate) {
        // Defensive copy - see Item 39
        this.birthDate = new Date(birthDate.getTime());
    }

    // Other fields, methods

    /**
     * The starting and ending dates of the baby boom.
     */
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0
                && birthDate.compareTo(BOOM_END) < 0;
    }
}
