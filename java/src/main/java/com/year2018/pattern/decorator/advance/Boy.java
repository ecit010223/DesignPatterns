package com.year2018.pattern.decorator.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 14:36
 */
public class Boy extends Person {
    @Override
    public void dressed() {
        //Boy类下dressed方法的基本逻辑
        System.out.println("穿着内衣内裤");
    }
}
