package com.year2018.pattern.chain_of_responsibility.advance;

/**
 * author：zyh
 * on: 2018/8/20 20:32
 */
public class Handler3 extends AbstractHandler {
    @Override
    protected int getHandleLevel() {
        return 3;
    }

    @Override
    protected void handle(AbstractRequest request) {
        System.out.println("Handler3 handle request:"+request.getRequestLevel());
    }
}
