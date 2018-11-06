package com.year2018.pattern.decorator;

/**
 * Author: zyh
 * Date: 2018/8/29 14:28
 * 装饰者具体实现类
 */
public class ConcreteDecoratorA extends Decorator {
    /**
     * 必要的构造方法，需要一个Component类型的对象
     *
     * @param component
     */
    protected ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        // 装饰方法A和B既可在父类方法前调用也可在之后调用
        operateA();
        super.operate();
        operateB();
    }

    /**
     * 自定义的装饰方法A
     */
    public void operateA(){
        //装饰方法逻辑...
    }

    /**
     * 自定义的装饰方法B
     */
    public void operateB(){

    }
}
