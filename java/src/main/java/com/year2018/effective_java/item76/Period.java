package com.year2018.effective_java.item76;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Author: zyh
 * Date: 2018/11/7 9:54
 */
public class Period implements Serializable {
    private Date start;
    private Date end;

    /**
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
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
    }

    public Date start() {
        return new Date(start.getTime());
    }

    public Date end() {
        return new Date(end.getTime());
    }

    public String toString() {
        return start + " - " + end;
    }

    // readObject method with validity checking - Page 304
    // This will defend against BogusPeriod attack but not MutablePeriod.
    // 不严格地说，readObject是一个“用字节流作为唯一参数”的构造器，因此也必须检查其参数的有效性。
    // 防止BogusPeriod.java中的攻击
//    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
//        s.defaultReadObject();
//
//        // Check that our invariants are satisfied
//        // 有效性检查
//        if (start.compareTo(end) > 0)
//            throw new InvalidObjectException(start + " after " + end);
//    }

    // readObject method with defensive copying and validity checking - Page 306
    // This will defend against BogusPeriod and MutablePeriod attacks.
    // 防止MutablePeriod.java中的攻击
    // 当一个对象被反序列化的时候，对于客户端不应该拥有的对象引用，如果哪个域包含了这样的对象引用，就必须
    // 要做保护性拷贝。
    // 对于final域，保护性拷贝是不可能的，为了使用readObject方法，必须要将start和end域做成非final的。
//    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
//        s.defaultReadObject();
//
//        // Defensively copy our mutable components
//        start = new Date(start.getTime());
//        end = new Date(end.getTime());
//
//        // Check that our invariants are satisfied
//        if (start.compareTo(end) > 0)
//            throw new InvalidObjectException(start + " after " + end);
//    }
}
