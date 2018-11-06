package com.year2018.pattern.chain_of_responsibility.advance_plus;

/**
 * author：zyh
 * on: 2018/8/20 20:44
 */
public class Director extends Leader {
    @Override
    public int limit() {
        return 5000;
    }

    @Override
    public void handler(int money) {
        System.out.println("主管批复报销"+money+"元");
    }
}
