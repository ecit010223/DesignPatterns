package com.year2018.pattern.visitor;

import java.util.Random;

/**
 * author：zyh
 * on: 2018/8/22 21:14
 * 工程师
 */
public class Engineer extends Staff {
    public Engineer(String aName){
        super(aName);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /** 工程师这一年定的代码数量 **/
    public int getCodeLines(){
        return new Random().nextInt(10*10000);
    }
}
