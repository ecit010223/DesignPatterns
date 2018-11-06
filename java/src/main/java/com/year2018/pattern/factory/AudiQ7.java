package com.year2018.pattern.factory;

/**
 * 作者：张玉辉 on 2018/4/19 21:52.
 */
public class AudiQ7 extends AudiCar {
    @Override
    public void drive() {
        System.out.println("Q7启动啦！");
    }

    @Override
    public void selfNavigation() {
        System.out.println("Q7开始自动巡航啦！");
    }
}
