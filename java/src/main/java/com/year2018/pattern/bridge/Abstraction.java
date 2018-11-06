package com.year2018.pattern.bridge;

/**
 * Author: zyh
 * Date: 2018/8/29 16:46
 * 抽象部分的实现
 * 该类保持一个对实现部分对象的引用，抽象部分中的方法需要调用实现部分的对象来实现，
 * 该类为一般为抽象类
 */
public abstract class Abstraction {
    /** 声明一个私有成员变量引用实现部分的对象 **/
    private Implementor mImplementor;

    public Abstraction(Implementor implementor){
        mImplementor = implementor;
    }

    /**
     * 通过调用实现部分具体的方法实现具体的功能
     */
    public void operation(){
        mImplementor.operationImpl();
    }
}
