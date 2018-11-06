package com.year2018.pattern.observable;

import java.util.Observable;

/**
 * author：zyh
 * on: 2018/8/21 20:48
 * 被观察者角色,当它有更新时，所有的观察者（这里指程序员）者会接到相应的通知。
 */
public class DevTechFrontier extends Observable {
    public void postNewPublication(String content){
        //标识状态或者内容发生改变
        setChanged();
        //通知所有观察者
        notifyObservers(content);
    }
}
