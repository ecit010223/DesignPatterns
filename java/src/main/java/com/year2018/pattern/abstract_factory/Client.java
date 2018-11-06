package com.year2018.pattern.abstract_factory;

/**
 * 作者：张玉辉 on 2018/4/19 21:41.
 * 抽象工厂方法
 */
public class Client {
    public static void main(String[] args){
        //构造一个Q3的工厂
        CarFactory factoryQ3 = new Q3Factory();
        factoryQ3.createTire().tire();
        factoryQ3.createEngine().engine();
        factoryQ3.createBrake().brake();

        //构造一个Q7的工厂
        CarFactory factoryQ7 = new Q7Factory();
        factoryQ7.createTire().tire();
        factoryQ7.createEngine().engine();
        factoryQ7.createBrake().brake();
    }
}
