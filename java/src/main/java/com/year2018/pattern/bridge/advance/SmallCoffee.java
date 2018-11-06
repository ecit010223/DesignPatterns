package com.year2018.pattern.bridge.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 16:58
 */
public class SmallCoffee extends Coffee {
    public SmallCoffee(CoffeeAdditives impl) {
        super(impl);
    }

    @Override
    public void makeCoffee() {
        System.out.println("小杯的"+impl.addSomething()+"咖啡");
    }
}
