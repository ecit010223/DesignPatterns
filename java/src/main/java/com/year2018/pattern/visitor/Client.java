package com.year2018.pattern.visitor;

/**
 * author：zyh
 * on: 2018/8/22 21:33
 */
public class Client {

    public static void main(String[] args){
        //构建报表
        BusinessReport report = new BusinessReport();
        System.out.println("===========给CEO看的报表=============");
        //设置访问者，这里是CEO
        report.showReport(new CEOVisitor());
        System.out.println("===========给CTO看的报表=============");
        //设置访问者，这里是CTO
        report.showReport(new CTOVisitor());
    }
}
