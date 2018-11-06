package com.year2018.pattern.mediator;

/**
 * author：zyh
 * on: 2018/8/22 21:47
 */
public class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator mediator){
        super(mediator);
    }

    @Override
    public void action() {
        System.out.println("ColleagueB将信息递交给中介者处理");
    }
}
