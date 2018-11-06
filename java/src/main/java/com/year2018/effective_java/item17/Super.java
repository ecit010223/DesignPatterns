package com.year2018.effective_java.item17;

/**
 * Author: zyh
 * Date: 2018/10/20 13:34
 */
public class Super {
    // Broken - constructor invokes an overridable method
    public Super() {
        overrideMe();
    }

    public void overrideMe() {
    }
}
