package com.year2018.annotation.custom;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: zyh
 * Date: 2018/10/26 9:07
 * @Retention：
 * 定义了该Annotation被保留的时间长短,某些Annotation仅出现在源代码中,而被编译器丢弃;而另一些却被编译在
 * class文件中;编译在class文件中的Annotation可能会被虚拟机忽略,而另一些在class被装载时将被读取（请注意
 * 并不影响class的执行,因为Annotation与class在使用上是被分离的）。使用这个meta-Annotation可以对
 * Annotation的“生命周期”限制。
 * 作用：
 * 表示需要在什么级别保存该注释信息,用于描述注解的生命周期（即:被描述的注解在什么范围内有效）
 * 取值(RetentionPolicy)有:
 * 1）SOURCE:在源文件中有效（即源文件保留）
 * 2）CLASS:在class文件中有效（即class保留）
 * 3）RUNTIME:在运行时有效（即运行时保留）
 */
@Target(ElementType.FIELD)
// RUNTIME：表示注解处理器可以通过反射,获取到该注解的属性值,从而去做一些运行时的逻辑处理
@Retention(RetentionPolicy.RUNTIME)
// @Documented用于描述其它类型的annotation应该被作为被标注的程序成员的公共API,因此可以被例如javadoc此类
// 的工具文档化。Documented是一个标记注解,没有成员。
@Documented
public @interface Column {
    String name() default "fieldName";

    String setFuncName() default "setField";

    String getFuncName() default "getField";

    boolean defaultDBValue() default false;
}
