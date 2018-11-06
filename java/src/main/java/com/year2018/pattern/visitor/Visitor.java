package com.year2018.pattern.visitor;

/**
 * author：zyh
 * on: 2018/8/22 21:12
 */
public interface Visitor {
    //访问工程师类型
    void visit(Engineer engineer);
    // 访问经理类型
    void visit(Manager leader);
}
