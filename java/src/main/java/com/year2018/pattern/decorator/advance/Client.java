package com.year2018.pattern.decorator.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 14:43
 */
public class Client {
    public static void main(String[] args){
        // 首先要有一个Person男孩
        Person person = new Boy();

        // 然后为他穿上便宜的衣服
        PersonCloth clothCheap = new CheapCloth(person);
        clothCheap.dressed();

        // 或者给他穿上比较上档次的衣服
        PersonCloth clothExpensive = new ExpensiveCloth(person);
        clothExpensive.dressed();
    }
}
