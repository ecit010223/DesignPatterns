package com.year2018.pattern.bridge.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 16:55
 * 该类中保持了对CoffeeAdditives的引用，以便调用具体的实现。
 * 同样地，咖啡还分大杯小杯，定义两个子类继承于Coffee
 */
public abstract class Coffee {
    protected CoffeeAdditives impl;

    public Coffee(CoffeeAdditives impl){
        this.impl = impl;
    }

    /**
     * 咖啡具体是什么样的由子类决定
     */
    public abstract void makeCoffee();
}
