package com.year2018.pattern.mediator;

/**
 * author：zyh
 * on: 2018/8/22 21:45
 */
public class ConcreteColleagueA extends Colleague {

    public ConcreteColleagueA(Mediator mediator){
        super(mediator);
    }
    @Override
    public void action() {
        System.out.println("ColleagueA 将信息递交给中介处理");
    }
}
