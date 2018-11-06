package com.year2018.pattern.abstract_factory;

/**
 * 作者：张玉辉 on 2018/4/19 21:39.
 */
public class NormalBrake implements IBrake {
    @Override
    public void brake() {
        System.out.println("普通制动");
    }
}
