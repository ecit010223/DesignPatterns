package com.year2018.effective_java.item29;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

/**
 * Author: zyh
 * Date: 2018/10/25 9:45
 * Use of asSubclass to safely cast to a bounded type token - Page 146
 */
public class PrintAnnotation {
    // Use of asSubclass to safely cast to a bounded type token
    static Annotation getAnnotation(AnnotatedElement element, String annotationTypeName) {
        Class<?> annotationType; // Unbounded type token
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        /**
         * annotationType是一个表示注解类型的有限制的类型令牌，如果元素有这种类型的注解，getAnnotation
         * 就将它返回，如果没有，则返回null。被注解的元素本质是个类型安全的异构容器，容器的键属于注解类
         * 型。
         * 假设有一个类型Class<?>的对象，并且想将它传给一个需要有限制的类型令牌的方法，例如getAnnotation，
         * 可以将对象转换成Class<? extends Annotation>，但是这种转换是非受检的，因此会产生一条编译时警告。
         * 但类Class提供了一个安全（且动态）地执行这种转换的实例方法，即asSubclass，它将调用它的Class对
         * 象转换成用其参数表示的类的一个子类，如果成功，返回它的参数，如果失败，则抛出ClassCastException
         * 异常。
         */
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

    // Test program to print named annotation of named class
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: java PrintAnnotation <class> <annotation>");
            System.exit(1);
        }
        String className = args[0];
        String annotationTypeName = args[1];
        Class<?> klass = Class.forName(className);
        System.out.println(getAnnotation(klass, annotationTypeName));
    }
}