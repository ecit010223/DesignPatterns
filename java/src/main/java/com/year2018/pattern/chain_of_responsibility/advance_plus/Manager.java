package com.year2018.pattern.chain_of_responsibility.advance_plus;

/**
 * author：zyh
 * on: 2018/8/20 20:45
 */
public class Manager extends Leader {
    @Override
    public int limit() {
        return 10000;
    }

    @Override
    public void handler(int money) {
        System.out.println("经理批复报销"+money+"元");
    }
}
