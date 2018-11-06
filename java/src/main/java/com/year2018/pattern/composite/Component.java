package com.year2018.pattern.composite;

/**
 * Author: zyh
 * Date: 2018/8/29 11:14
 * 抽象根节点
 */
public abstract class Component {
    /** 节点名 **/
    protected String name;

    public Component(String name){
        this.name = name;
    }

    /** 具体的逻辑方法由子类实现 **/
    public abstract void doSomething();
}
