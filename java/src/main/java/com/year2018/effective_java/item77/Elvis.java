package com.year2018.effective_java.item77;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Author: zyh
 * Date: 2018/11/7 10:19
 */
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    /**
     * 该方法保存了该类的单例特性，而readObject则不能。
     * 该方法的特性允许用readObject创建的实例代替另一个实例，对于一个正在被反序列化的对象，如果它的类定
     * 义了一个readResolve方法，并且具备正确的声明，那么在反序列化之后，新建对象上的readResolve方法就会
     * 被调用。然后，该方法返回的对象引用将被返回，取代新建的对象。在这个特性的绝大数用法中，指向新建对象
     * 的引用不需要再被保留，因此立即成为垃圾回收的对象。
     */
    private Object readResolve() throws ObjectStreamException {
        // 该方法忽略了被反序列化的对象，只返回该类初始化时创建的那个特殊的Elvis实例。
        // 因此，该类的序列化形式不需要包含任何实际的数据，所有的实例域都应该被声明为transient
        return INSTANCE;
    }
}
