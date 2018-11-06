package com.year2018.pattern.builder;

/**
 * author：zyh
 * on: 2018/7/31 21:17
 * 封装了构建复杂产品对象的过程，对外隐藏构建细节。
 * 在实际开发中，Director角色经常会被省略。而直接使用一个Builder来进行对象的组装，
 * 这个Builder通常为链式调用，它的关键点是每个setter方法都返回自身，也就是return this，
 * 这样就使得setter方法可以链试调用，如：
 * new TestBuilder().setA("A").setB("B").create();
 */
public class Director {
    Builder mBuilder = null;

    public Director(Builder builder){
        mBuilder = builder;
    }

    /** 构建对象 **/
    public void construct(String board, String display){
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }
}
