package com.year2018.annotation.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Author: zyh
 * Date: 2018/10/26 9:28
 * ElementType.FIELD仅可用于注解类的成员变量
 */
@Target(ElementType.FIELD)
public @interface NoDBColumn {
}
