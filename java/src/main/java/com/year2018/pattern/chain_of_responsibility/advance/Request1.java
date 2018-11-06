package com.year2018.pattern.chain_of_responsibility.advance;

/**
 * author：zyh
 * on: 2018/8/20 20:26
 */
public class Request1 extends AbstractRequest {

    public Request1(Object obj) {
        super(obj);
    }

    @Override
    public int getRequestLevel() {
        return 1;
    }
}
