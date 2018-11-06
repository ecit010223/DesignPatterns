package com.year2018.pattern.singleton;

/**
 * 作者：张玉辉 on 2018/4/25 20:02.
 */
public class StaticSingleton {
    private StaticSingleton(){}

    public static StaticSingleton getInstance(){
        return StaticSingletonHolder.sInstance;
    }

    /** 静态内部类 **/
    private static class StaticSingletonHolder{
        private static final StaticSingleton sInstance = new StaticSingleton();
    }
}
