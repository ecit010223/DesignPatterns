package com.year2018.pattern.visitor;

/**
 * author：zyh
 * on: 2018/8/22 21:29
 * 不是Visitor模式，则需要对不同的员工类型进行判断
 */
public class ReportUtil {
    public void visit(Staff staff){
        if(staff instanceof Manager){
            Manager mgr = (Manager)staff;
            System.out.println("经理："+mgr.name+",KPI:"+mgr.kpi+"新产品数量："+mgr.getProducts());
        }else {
            Engineer engineer = (Engineer)staff;
            System.out.println("工程师："+engineer.name+",kpi:"+engineer.kpi);
        }
    }
}
