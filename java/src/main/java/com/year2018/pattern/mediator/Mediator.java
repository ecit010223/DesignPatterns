package com.year2018.pattern.mediator;

/**
 * author：zyh
 * on: 2018/8/22 21:38
 * 抽象中介者
 */
public abstract class Mediator {
    /** 具体同事类A **/
    protected ConcreteColleagueA colleagueA;
    /** 具体同事类B **/
    protected ConcreteColleagueB colleagueB;

    /**  抽象中介方法、子类实现 **/
    public abstract void method();

    public void setColleagueA(ConcreteColleagueA colleagueA){
        this.colleagueA = colleagueA;
    }

    public void setColleagueB(ConcreteColleagueB colleagueB){
        this.colleagueB = colleagueB;
    }
}
