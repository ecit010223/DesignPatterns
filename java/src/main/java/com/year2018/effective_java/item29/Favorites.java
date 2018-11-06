package com.year2018.effective_java.item29;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: zyh
 * Date: 2018/10/25 9:45
 * Typesafe heterogeneous container - Pages 142-145
 */
public class Favorites {
    // Typesafe heterogeneous container pattern - implementation
    private Map<Class<?>, Object> favorites = new HashMap<Class<?>, Object>();

    public <T> void putFavorite(Class<T> type, T instance) {
        if (type == null)
            throw new NullPointerException("Type is null");
        /**
         * 你可能认为由于无限制通配符类型的关系，将不能把任何东西放进这个Map中，但事实正好相反，要注意的
         * 是通配符类型是嵌套的，它不是属于通配符类型Map的类型，而是它的键的类型。
         */
        favorites.put(type, instance);
    }

    /**
     * cast方法：动态类型转换，只是做了一些安全措施，它只检查它的参数是否为Class对象所表示的类型的实例。
     * favorites Map的值类型只是Object，即Map并不能保证键和值之间的类型关系，不能保证每个值的类型都与键
     * 的类型相同
     */
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    // Typesafe heterogeneous container pattern - client
    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger,
                favoriteClass.getName());
    }
}