package com.year2018.pattern.decorator;

/**
 * Author: zyh
 * Date: 2018/8/29 14:31
 */
public class Client {
    public static void main(String[] args){
        //构造被装饰的组件对象
        Component component = new ConcreteComponent();

        //根据组件对象构造装饰者对象A并调用，此时相当于给组件对象增加装饰者A的功能方法
        Decorator decorator = new ConcreteDecoratorA(component);
        decorator.operate();
    }
}
