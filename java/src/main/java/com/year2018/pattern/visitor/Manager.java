package com.year2018.pattern.visitor;

import java.util.Random;

/**
 * author：zyh
 * on: 2018/8/22 21:18
 * 经理类型
 */
public class Manager extends Staff {
    /** 产品数量 **/
    private int products;

    public Manager(String aName){
        super(aName);
        products = new Random().nextInt(10);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /** 一年内做的产品数量 **/
    public int getProducts(){
        return products;
    }
}
