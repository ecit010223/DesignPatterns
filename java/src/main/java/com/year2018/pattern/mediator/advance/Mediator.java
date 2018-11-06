package com.year2018.pattern.mediator.advance;

/**
 * author：zyh
 * on: 2018/8/22 21:48
 * 抽象中介者
 */
public abstract class Mediator {
    /**
     * 同事对象改变时通知中介者的方法，
     * 在同事对象改变时由中介者对通知其它的同事对象
     * @param c 同事对象
     */
    public abstract void changed(Colleague c);
}
