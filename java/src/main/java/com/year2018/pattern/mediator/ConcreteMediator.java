package com.year2018.pattern.mediator;

/**
 * author：zyh
 * on: 2018/8/22 21:42
 * 具体中介者
 */
public class ConcreteMediator extends Mediator {
    @Override
    public void method() {
        colleagueA.action();
        colleagueB.action();
    }
}
