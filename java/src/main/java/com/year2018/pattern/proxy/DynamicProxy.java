package com.year2018.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 作者：张玉辉 on 2018/4/25 20:43.
 * 动态代理通过反射机制动态地生成代理者的对象，也就是说在code阶段压根就不需要知道代理谁，
 * 代理会在执行阶段决定。
 */
public class DynamicProxy implements InvocationHandler {
    /** 被代理的类引用 **/
    private Object mObject;
    public DynamicProxy(Object object){
        this.mObject = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 调用被代理类对象的方法，不写此行代码，被代理对象对应的method不会被调用
        Object result = method.invoke(mObject,args);
        return result;
    }
}
