package com.year2018.pattern.factory;

/**
 * 作者：张玉辉 on 2018/4/19 21:53.
 */
public class Client {
    public void main(String[] args){
        //构造一个制造汽车的工厂对象
        AudiCarFactory factory = new AudiCarFactory();

        //生产Q3并启动
        AudiQ3 audiQ3 = factory.createAudiCar(AudiQ3.class);
        audiQ3.drive();
        audiQ3.selfNavigation();

        //生产Q5并启动
        AudiQ5 audiQ5 = factory.createAudiCar(AudiQ5.class);
        audiQ5.drive();
        audiQ5.selfNavigation();

        //生产Q7并启动
        AudiQ7 audiQ7 = factory.createAudiCar(AudiQ7.class);
        audiQ7.drive();
        audiQ7.selfNavigation();
    }
}
