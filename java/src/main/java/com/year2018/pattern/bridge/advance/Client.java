package com.year2018.pattern.bridge.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 17:02
 * 如推出中杯的咖啡，则只需创建一个extends Coffee的MiddleCoffee类
 * 如推出新的口味，则只需创建一个extends CoffeeAdditive的新类就可以了
 */
public class Client {
    public static void main(String[] args){
        //原汁原味
        Ordinary implOrdinary = new Ordinary();

        // 准备糖类
        Sugar implSugar = new Sugar();

        // 大杯咖啡 原味
        LargeCoffee largeCoffeeOrdinary = new LargeCoffee(implOrdinary);
        largeCoffeeOrdinary.makeCoffee();

        //小杯咖啡 原味
        SmallCoffee smallCoffeeOrdinary = new SmallCoffee(implOrdinary);
        smallCoffeeOrdinary.makeCoffee();

        // 大杯咖啡 加糖
        LargeCoffee largeCoffeeSugar = new LargeCoffee(implSugar);
        largeCoffeeSugar.makeCoffee();

        // 小杯咖啡 加糖
        SmallCoffee smallCoffeeSugar = new SmallCoffee(implSugar);
        smallCoffeeSugar.makeCoffee();
    }
}
