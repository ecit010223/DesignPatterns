package com.year2018.pattern.factory;

/**
 * 作者：张玉辉 on 2018/4/19 21:50.
 */
public class AudiQ3 extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q3 启动啦");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q3开始自动巡航");
    }
}
