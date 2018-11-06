package com.year2018.pattern.stragety;

/**
 * 作者：张玉辉 on 2018/4/25 20:14.
 */
public interface CalculateStrategy {
    /**
     * 按距离来计算价格
     * @param km
     * @return
     */
    int calculatePrice(int km);
}
