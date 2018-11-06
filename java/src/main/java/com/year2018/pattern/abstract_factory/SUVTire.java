package com.year2018.pattern.abstract_factory;

/**
 * 作者：张玉辉 on 2018/4/19 21:37.
 */
public class SUVTire implements ITire {
    @Override
    public void tire() {
        System.out.println("越野轮胎");
    }
}
