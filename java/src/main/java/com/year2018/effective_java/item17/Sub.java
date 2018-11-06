package com.year2018.effective_java.item17;

import java.util.Date;

/**
 * Author: zyh
 * Date: 2018/10/20 13:35
 */
public class Sub extends Super {
    // Blank final, set by constructor
    private final Date date;

    Sub() {
        date = new Date();
    }

    // Overriding method invoked by superclass constructor
    // 注意：如果overrideMe已经调用了date中的任何方法，当Super构造器调用overrideMe的时候，调用就会抛出
    // NullPointerException异常。如果该程序没有抛出NullPointerException异常，唯一的原因就在于println
    // 方法对于处理null参数有着特殊的规定。
    @Override
    public void overrideMe() {
        System.out.println(date);
    }

    //会打印两次，但第一次打印出的是null。
    //因为overrideMe方法被Super构造器调用的时候，构造器Sub还没机会初始化date域。
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
