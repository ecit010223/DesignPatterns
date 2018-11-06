package com.year2018.pattern.chain_of_responsibility.advance_plus;

/**
 * author：zyh
 * on: 2018/8/20 20:40
 */
public abstract class Leader {
    /**
     * 上一级领导处理者
     */
    protected Leader nextHandler;

    public final void handleRequest(int money){
        if(money<=limit()){
            handler(money);
        }else{
            if (null!=nextHandler){
                nextHandler.handleRequest(money);
            }
        }
    }

    /**
     * 自身能批复的额度权限
     * @return 额度
     */
    public abstract int limit();

    /**
     * 处理报账行为
     * @param money 具体金额
     */
    public abstract void handler(int money);
}
