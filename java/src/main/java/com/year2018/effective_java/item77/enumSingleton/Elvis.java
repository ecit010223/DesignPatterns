package com.year2018.effective_java.item77.enumSingleton;

import java.util.Arrays;

/**
 * Author: zyh
 * Date: 2018/11/7 10:21
 */
public enum Elvis {
    INSTANCE;
    private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}
