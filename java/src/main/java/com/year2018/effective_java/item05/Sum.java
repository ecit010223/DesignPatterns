package com.year2018.effective_java.item05;

/**
 * Author: zyh
 * Date: 2018/10/18 15:02
 */
public class Sum {
    // Hideously slow program! Can you spot the object creation?
    // 因为sum被声明为Long，每次向sum中增加long时都构造了一个Long型
    public static void main(String[] args) {
        Long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
    }
}
