package com.year2018.effective_java.item78;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Author: zyh
 * Date: 2018/11/7 10:45
 */
public final class Period implements Serializable {
    private final Date start;
    private final Date end;

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

    // Serialization proxy for Period class - page 312
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }

        private static final long serialVersionUID = 234098243823485285L; // Any
        // number will do (Item 75)

        // readResolve method for Period.SerializationProxy - Page 313
        // 该方法导致序列化系统在反序列化时将序列化代理转变回外围类的实例。
        private Object readResolve() {
            return new Period(start, end); // Uses public constructor
        }
    }

    // writeReplace method for the serialization proxy pattern - page 312
    // 该方法导致序列化产生个SerializationProxy实例，代替外围类的实例。
    // 换句话说，writeReplace方法在序列化之前，将外围类的实例转变成了它的序列化代理。
    // 有了该方法后，序列化系统永远不会产生外围类的序列化实例。
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // readObject method for the serialization proxy pattern - Page 313
    // 如果攻击者仿造了外围类实例，则抛出异常，使攻击无法得逞
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
}
