package com.year2018.pattern.proxy;

import java.lang.reflect.Proxy;

/**
 * 作者：张玉辉 on 2018/4/25 20:47.
 */
public class DynamicClient {
    public static void main(String args[]){
        // 构造一个小民
        ILawsuit xiaomin = new XiaoMin();
        // 构造一个动态代理
        DynamicProxy dynamicProxy = new DynamicProxy(xiaomin);
        // 获取被代理类小民的ClassLoader
        ClassLoader loader = xiaomin.getClass().getClassLoader();
        // 动态构造一个代理者律师
        ILawsuit lawyer = (ILawsuit) Proxy.newProxyInstance(loader,new Class[]{
                ILawsuit.class
        },dynamicProxy);
        // lawyer每次调用成员方法前，都会先调用DynamicProxy中的invoke方法，因此可以拦截
        // 成员方法的操作
        lawyer.submit();
        lawyer.burden();
        lawyer.defend();
        lawyer.finish();
    }
}
