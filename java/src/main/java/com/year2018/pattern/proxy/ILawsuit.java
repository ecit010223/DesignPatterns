package com.year2018.pattern.proxy;

/**
 * 作者：张玉辉 on 2018/4/25 20:31.
 * 诉讼接口类
 */
public interface ILawsuit {
    // 提交申请
    void submit();

    // 进行举证
    void burden();

    // 开始辩护
    void defend();

    // 诉讼完成
    void finish();
}
