package com.year2018.pattern.proxy;

/**
 * 作者：张玉辉 on 2018/4/25 20:38.
 */
public class Client {
    public static void main(String args[]){
        // 构造一个小民
        ILawsuit xiaomin = new XiaoMin();
        // 构造一个代理律师并将小民作为构造参数传递进去
        ILawsuit lawyer = new Lawyer(xiaomin);
        // 律师提交诉讼申请
        lawyer.submit();
        // 律师进行举证
        lawyer.burden();
        // 律师代替小民进行辩护
        lawyer.defend();
        //完成诉讼
        lawyer.finish();
    }
}
