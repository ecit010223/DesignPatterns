package com.year2018.pattern.observable;

import java.util.Observable;
import java.util.Observer;

/**
 * author：zyh
 * on: 2018/8/21 20:46
 * 程序员是观察者
 */
public class Coder implements Observer {
    public String name;

    public Coder(String aName){
        name = aName;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hi, "+name+",DevTechFrontier更新啦，内容："+arg);
    }

    @Override
    public String toString() {
        return "码农:"+name;
    }
}
