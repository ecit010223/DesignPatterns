package com.year2018.effective_java.item74;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Author: zyh
 * Date: 2018/11/6 13:30
 */
public class Foo extends AbstractFoo implements Serializable {
    private void readObject(ObjectInputStream s) throws IOException,ClassNotFoundException {
        s.defaultReadObject();
        // Manually deserialize and initialize superclass state
        int x = s.readInt();
        int y = s.readInt();
        initialize(x, y);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();

        // Manually serialize superclass state
        s.writeInt(getX());
        s.writeInt(getY());
    }

    // Constructor does not use the fancy mechanism
    public Foo(int x, int y) {
        super(x, y);
    }

    private static final long serialVersionUID = 1856835860954L;
}
