package com.year2018.pattern.proxy;

/**
 * 作者：张玉辉 on 2018/4/25 20:36.
 */
public class Lawyer implements ILawsuit {
    // 持有一个具体被代理者的引用
    private ILawsuit mLawsuit;

    public Lawyer(ILawsuit lawsuit){
        mLawsuit = lawsuit;
    }

    @Override
    public void submit() {
        mLawsuit.submit();
    }

    @Override
    public void burden() {
        mLawsuit.burden();
    }

    @Override
    public void defend() {
        mLawsuit.defend();
    }

    @Override
    public void finish() {
        mLawsuit.finish();
    }
}
