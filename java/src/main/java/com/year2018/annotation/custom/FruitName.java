package com.year2018.annotation.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: zyh
 * Date: 2018/10/26 9:13
 * 自定义注解:
 * 使用@interface自定义注解时,自动继承了java.lang.annotation.Annotation接口,由编译程序自动完成其他细节,
 * 在定义注解时,不能继承其他的注解或接口.
 * 用@interface声明一个注解,其中的每一个方法实际上是声明了一个配置参数,方法的名称就是参数的名称,返回值类
 * 型就是参数的类型(返回值类型只能是基本类型、Class、String、enum),可以通过default来声明参数的默认值.
 * 定义注解格式:
 * public @interface 注解名 {定义体}
 * 注解参数的可支持数据类型:
 * 1）所有基本数据类型(int,float,boolean,byte,double,char,long,short)
 * 2）String类型
 * 3）Class类型
 * 4）enum类型
 * 5）Annotation类型
 * 6）以上所有类型的数组
 * Annotation类型里面的参数该怎么设定:
 * 1）默认访问权修饰即public，例如,String value();这里把方法设为default默认类型;
 * 2）参数成员只能用基本类型byte,short,char,int,long,float,double,boolean八种基本数据类型和
 *    String,Enum,Class,annotations等数据类型,以及这一些类型的数组.例如:String value();这里的参数成员
 *    就为String;
 * 3）如果只有一个参数成员,最好把参数名称设为"value",后加小括号.例:下面的例子FruitName注解就只有一个参
 *    数成员(即value())。
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
