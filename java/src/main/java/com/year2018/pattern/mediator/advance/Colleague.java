package com.year2018.pattern.mediator.advance;

/**
 * author：zyh
 * on: 2018/8/22 21:58
 * 抽象同事
 */
public abstract class Colleague {
    /** 每一个同事都该知道基中介者 **/
    protected Mediator mediator;

    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
}
