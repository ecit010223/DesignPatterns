package com.year2018.effective_java.item35;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: zyh
 * Date: 2018/10/25 16:20
 * Test注解类型的声明就是它自身通过Retention和Target注解进行了注解。
 * 注解类型声明中的这种注解被称作元注解（meta-annotation）
 * @Retention(RetentionPolicy.RUNTIME)
 */
@Retention(RetentionPolicy.RUNTIME)
// 它只能用于无参的静态方法
@Target(ElementType.METHOD)
public @interface Test {
}
