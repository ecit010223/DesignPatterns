package com.year2018.pattern.chain_of_responsibility;

/**
 * author：zyh
 * on: 2018/8/20 20:12
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(String condition) {
        if(condition.equals("ConcreteHandler2")){
            System.out.println("ConcreteHandler2 handled");
        }else{
            successor.handleRequest(condition);
        }
    }
}
