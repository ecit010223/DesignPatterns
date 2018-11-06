package com.year2018.pattern.template_method;

/**
 * author：zyh
 * on: 2018/8/22 21:03
 */
public class Test {

    public static void main(String[] args){
        AbstractComputer computer = new CoderComputer();
        computer.startUp();

        computer = new MilitaryComputer();
        computer.startUp();
    }
}
