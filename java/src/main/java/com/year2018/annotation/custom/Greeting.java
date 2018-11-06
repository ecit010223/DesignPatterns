package com.year2018.annotation.custom;

import java.lang.annotation.Inherited;

/**
 * Author: zyh
 * Date: 2018/10/26 9:18
 * @Inherited:
 * 阐述了某个被标注的类型是被继承的,如果一个使用了@Inherited修饰的annotation类型被用于一个class,则这个
 * Annotation将被用于该class的子类.
 * 注意:@Inherited annotation类型是被标注过的class的子类所继承,类并不从它所实现的接口继承annotation,
 * 方法并不从它所重载的方法继承annotation.
 * 当@Inherited annotation类型标注的annotation的Retention是RetentionPolicy.RUNTIME,则反射API增强了这
 * 种继承性.如果我们使用java.lang.reflect去查询一个@Inherited annotation类型的annotation时,反射代码检
 * 查将展开工作:检查class和其父类，直到发现指定的annotation类型被发现,或者到达类继承结构的顶层.
 */
@Inherited
public @interface Greeting {
    enum FontColor{ BLUE,RED,GREEN};

    String name();

    FontColor fontColor() default FontColor.GREEN;
}
