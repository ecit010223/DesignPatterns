package com.year2018.pattern.chain_of_responsibility.advance_plus;

/**
 * author：zyh
 * on: 2018/8/20 20:43
 */
public class GroupLeader extends Leader {
    @Override
    public int limit() {
        return 1000;
    }

    @Override
    public void handler(int money) {
        System.out.println("组长批复报销"+money+"元");
    }
}
