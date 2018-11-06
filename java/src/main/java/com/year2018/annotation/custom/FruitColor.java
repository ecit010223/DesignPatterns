package com.year2018.annotation.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: zyh
 * Date: 2018/10/26 9:11
 * 水果颜色注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /** 颜色枚举 */
    enum Color{ BLUE,RED,GREEN};

    /** 颜色属性 */
    Color fruitColor() default Color.GREEN;
}
