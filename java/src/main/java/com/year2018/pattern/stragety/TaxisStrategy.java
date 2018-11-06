package com.year2018.pattern.stragety;

/**
 * 作者：张玉辉 on 2018/4/25 20:23.
 * 出租车计算策略
 */
public class TaxisStrategy implements CalculateStrategy {
    @Override
    public int calculatePrice(int km) {
        return km*2;
    }
}
