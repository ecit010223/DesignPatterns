package com.year2018.effective_java.item35;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: zyh
 * Date: 2018/10/25 16:21
 * 针对只在抛出特殊异常时才成功的测试
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    //参数类型是某个扩展Exception的类的Class对象
    Class<? extends Exception>[] value();
}
