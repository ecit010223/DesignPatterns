package com.year2018.pattern.chain_of_responsibility;

/**
 * author：zyh
 * on: 2018/8/20 20:07
 * 抽象处理者
 */
public abstract class Handler {
    /** 下一节点的处理者 **/
    protected Handler successor;

    /**
     * 请求处理
     * @param condition 请求条件
     */
    public abstract void handleRequest(String condition);
}
