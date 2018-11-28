package com.year2018.pattern.singleton;

/**
 * 作者：张玉辉 on 2018/4/25 20:06.
 * 访问方式：SingletonEnum.INSTANCE.doSomething();
 */
public enum  SingletonEnum {
    INSTANCE;
    public void doSomething(){
        System.out.println("do sth.");
    }
}
