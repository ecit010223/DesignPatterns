package com.year2018.pattern.abstract_factory;

/**
 * 作者：张玉辉 on 2018/4/19 21:33.
 */
public abstract class CarFactory {
    /**
     * 生产轮胎
     */
    public abstract ITire createTire();

    /**
     * 生产发动机
     */
    public abstract IEngine createEngine();

    /**
     * 生产制动系统
     */
    public abstract IBrake createBrake();
}
