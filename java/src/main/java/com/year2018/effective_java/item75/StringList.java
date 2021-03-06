package com.year2018.effective_java.item75;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Author: zyh
 * Date: 2018/11/6 14:04
 */
public class StringList implements Serializable {
    // transient修饰符表明这个实例域将从一个类的默认序列化形式中省略掉。
    // 从技术角度而言，不调用defaultWriteObject和defaultReadObject也是允许的，但是不推荐这样做。
    private transient int size = 0;
    private transient Entry head = null;

    // No longer Serializable!
    private static class Entry {
        String data;
        Entry next;
        Entry previous;
    }

    // Appends the specified string to the list
    public final void add(String s) {
        // Implementation omitted
    }

    /**
     * Serialize this {@code StringList} instance.
     *
     * @serialData The size of the list (the number of strings it contains) is
     *             emitted ({@code int}), followed by all of its elements (each
     *             a {@code String}), in the proper sequence.
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (Entry e = head; e != null; e = e.next)
            s.writeObject(e.data);
    }

    private void readObject(ObjectInputStream s) throws IOException,
            ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();

        // Read in all elements and insert them in list
        for (int i = 0; i < numElements; i++)
            add((String) s.readObject());
    }

    private static final long serialVersionUID = 93248094385L;
    // Remainder omitted
}
