package com.year2018.pattern.visitor;

import java.util.Random;

/**
 * author：zyh
 * on: 2018/8/22 21:10
 * 员工基类
 */
public abstract class Staff {
    public String name;
    // 员工kpi
    public int kpi;

    public Staff(String name){
        this.name = name;
        kpi = new Random().nextInt(10);
    }

    //接受Visitor的访问
    public abstract void accept(Visitor visitor);
}
