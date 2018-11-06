package com.year2018.pattern.composite;

/**
 * Author: zyh
 * Date: 2018/8/29 11:20
 * 具体叶子节点
 */
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void doSomething() {
        System.out.println(name);
    }
}
