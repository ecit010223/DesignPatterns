package com.year2018.effective_java.item39;

import java.util.Date;

/**
 * Author: zyh
 * Date: 2018/10/31 16:54
 */
public final class Period {
    private final Date start;
    private final Date end;

    /**
     * 如下的方式易受攻击，虽然在该类的内部将start与end定义成final，但Date类本身是可变的，
     * 攻击方式见Attack.java的攻击1
     * @param start
     *            the beginning of the period
     * @param end
     *            the end of the period; must not precede start
     * @throws IllegalArgumentException
     *             if start is after end
     * @throws NullPointerException
     *             if start or end is null
     */
    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
        this.start = start;
        this.end = end;
    }

    /**
     * Repaired constructor - makes defensive copies of parameters - Page 185
     * 为了保护Period实例的内部信息避免受到如上构造方式的攻击，对于构造器的每个可变参数进行保护性拷贝
     * 是必要的。
     * 注意：保护性拷贝是在检查参数的有效性之前进行的，并且有效性检查是针对拷贝之后的对象，而不是针对
     * 原始的对象。
     * 注意：没有用Date的clone方法来进行保护性拷贝，因为Date是非final的，不能保证clone方法一定返回类
     * 为java.util.Date的对象，它有可能返回专门出于恶意的目的而设计的不可信子类的实例。
     */
//    public Period(Date start, Date end) {
//        this.start = new Date(start.getTime());
//        this.end = new Date(end.getTime());
//
//        if (this.start.compareTo(this.end) > 0)
//            throw new IllegalArgumentException(start + " after " + end);
//    }

    public Date start() {
        return start;
    }

    /**
     * 该方法可被Attack.java的攻击2所攻击
     */
    public Date end() {
        return end;
    }

    /**
     * Repaired accessors - make defensive copies of internal fields - Page 186
     * Stops second attack
     * 访问方法与构造器不同，它们在进行保护性拷贝的时候允许使用clone方法，之所以如此，是因为Period内部
     * 的Date对象的类是java.util.Date，而不可能是其它某个潜在的不可信子类。
     */
//    public Date start() {
//        return new Date(start.getTime());
//    }

//    public Date end() {
//        return new Date(end.getTime());
//    }

    public String toString() {
        return start + " - " + end;
    }

    // Remainder omitted
}
