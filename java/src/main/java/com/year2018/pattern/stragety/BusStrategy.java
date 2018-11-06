package com.year2018.pattern.stragety;

/**
 * 作者：张玉辉 on 2018/4/25 20:16.
 * 公交车价格计算策略
 */
public class BusStrategy implements CalculateStrategy {
    @Override
    public int calculatePrice(int km) {
        int extraTotal = km-10;
        int extraFactor = extraTotal/5;
        int fraction = extraTotal%5;
        int price = 1 + extraFactor*1;
        return fraction>0?++price:price;
    }
}
