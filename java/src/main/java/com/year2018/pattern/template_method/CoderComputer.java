package com.year2018.pattern.template_method;

/**
 * author：zyh
 * on: 2018/8/22 21:01
 * 程序员的计算机
 */
public class CoderComputer extends AbstractComputer {
    @Override
    protected void login() {
        System.out.println("程序员只需要进行用户和密码验证可以了");
    }
}
