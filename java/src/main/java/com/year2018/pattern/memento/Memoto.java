package com.year2018.pattern.memento;

/**
 * author：zyh
 * on: 2018/8/21 21:06
 * 备忘录类
 */
public class Memoto {
    public int mCheckPoint;
    public int mLifeValue;
    public String mWeapon;

    @Override
    public String toString() {
        return "Memoto [mCheckPoint="+mCheckPoint+",mLifeValue="+mLifeValue+",mWeapon="+mWeapon+"]";
    }
}
