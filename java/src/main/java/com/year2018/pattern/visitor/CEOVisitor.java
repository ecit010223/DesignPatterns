package com.year2018.pattern.visitor;

/**
 * author：zyh
 * on: 2018/8/22 21:26
 * CEO访问者，只关注业绩
 */
public class CEOVisitor implements Visitor {

    @Override
    public void visit(Engineer engineer) {
        System.out.println("工程师："+engineer.name+",KPI:"+engineer.kpi);
    }

    @Override
    public void visit(Manager leader) {
        System.out.println("经理："+leader.name+",KPI:"+leader.kpi+"新产品数量："+leader.getProducts());
    }
}
