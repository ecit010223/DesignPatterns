package com.year2018.pattern.stragety;

/**
 * 作者：张玉辉 on 2018/4/25 20:24.
 */
public class TrafficCalculator {
    public static void main(String args[]){
        TrafficCalculator calculator = new TrafficCalculator();
        //设置计算策略
        calculator.setStrategy(new TaxisStrategy());
        System.out.println("出租车乘16公里的价格："+calculator.calculatePrice(16));
    }

    CalculateStrategy mStrategy;
    public void setStrategy(CalculateStrategy strategy){
        this.mStrategy = strategy;
    }
    public int calculatePrice(int km){
        return mStrategy.calculatePrice(km);
    }
}
