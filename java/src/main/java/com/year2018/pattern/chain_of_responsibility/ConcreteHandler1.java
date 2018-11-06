package com.year2018.pattern.chain_of_responsibility;

/**
 * author：zyh
 * on: 2018/8/20 20:10
 */
public class ConcreteHandler1 extends Handler{

    @Override
    public void handleRequest(String condition) {
        if(condition.equals("ConcreteHandler1")){
            System.out.println("ConcreteHandler1 handled");
            return;
        }else {
            successor.handleRequest(condition);
        }
    }
}
