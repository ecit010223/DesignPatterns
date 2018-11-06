package com.year2018.pattern.chain_of_responsibility.advance;

/**
 * author：zyh
 * on: 2018/8/20 20:31
 */
public class Handler2 extends AbstractHandler {
    @Override
    protected int getHandleLevel() {
        return 2;
    }

    @Override
    protected void handle(AbstractRequest request) {
        System.out.println("Handler2 handle request:"+request.getRequestLevel());
    }
}
