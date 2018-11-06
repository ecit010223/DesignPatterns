package com.year2018.effective_java.item04;

/**
 * Author: zyh
 * Date: 2018/10/18 14:31
 * AssertionError不是必须让，但是它可以避免不小心在类的内部调用构造器
 */
public class UtilityClass {
    // Suppress default constructor for noninstantiability
    private UtilityClass() {
        throw new AssertionError();
    }
}
