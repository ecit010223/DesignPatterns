package com.year2018.pattern.chain_of_responsibility.advance_plus;

/**
 * author：zyh
 * on: 2018/8/20 20:47
 */
public class Worker {
    public static void main(String[] args){
        GroupLeader groupLeader = new GroupLeader();
        Director director = new Director();
        Manager manager = new Manager();
        Boss boss = new Boss();

        //设置上一级领导处理者对象
        groupLeader.nextHandler = director;
        director.nextHandler = manager;
        manager.nextHandler = boss;

        //发起报账申请
        groupLeader.handleRequest(50000);
    }
}
