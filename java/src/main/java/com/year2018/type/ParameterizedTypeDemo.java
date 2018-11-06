package com.year2018.type;

import com.year2018.type.bean.GenericArrayTypeBean;
import com.year2018.type.bean.ParameterizedTypeBean;
import com.year2018.type.bean.TypeVariableBean;
import com.year2018.type.bean.WildcardTypeBean;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/**
 * 作者：张玉辉 on 2018/4/22 10:46.
 * 类型擦除是指泛型在运行的时候会去除泛型的类型信息。java中，泛型主要是在编译层次来实现的，在生成的字节
 * 码即class文件是不包括泛型的类型信息的。即List，List虽然在编译时候是不同的，但是在编译完成后，
 * 在class文件中都只会把他们当作List来对待。
 * Type是所有类型的父接口, 如原始类型(raw types对应Class)、参数化类型(parameterized types对应
 * ParameterizedType)、数组类型(array types对应GenericArrayType)、类型变量(type variables对应
 * TypeVariable)和基本(原生)类型(primitive types对应Class)。如下：
 *
 * GenericArrayType{
 *     getGenericComponentType():Type
 * }
 *
 * Class
 *
 * ParameterizedType{  //参数化类型:parameterized types
 *     // getActualTypeArguments()返回这个Type类型的参数的实际类型数组。如Map<String,Person>
 *     // map这个ParameterizedType返回的是String类与Person类的全限定类名的Type数组。
 *     getActualTypeArguments(): Type[]
 *     // getRawType()返回的是当前这个ParameterizedType的类型。如Map<String,Person> map
 *     // 这个ParameterizedType返回的是Map类的全限定类名的Type数组。
 *     getRawType():Type
 *     // 返回的是这个ParameterizedType 所在的类的Type
 *     getOwnerType():Type
 * }
 *
 * TypeVariable{
 *      // 得到上边界的Type数组，如实例中K的上边界数组是InputStream和Serializable。
 *      // V没有指定的话，上边界是Object
 *      getBounds():Type[]
 *      // 返回的是声明这个Type所在的类的Type
 *      getGenericDeclaration():D
 *      // 返回的是这个type variable的名称
 *      getName():String
 * }
 *
 * WildcardType{
 *      // 得到上边界 Type 的数组
 *      getUpperBounds():Type[]
 *      //  得到下边界 Type 的数组
 *      getLowerBounds():Type[]
 * }
 */
public class ParameterizedTypeDemo {

    public static void main(String[] args){
        analyzeParameterizedType();
//        analyzeTypeVariable();
//        analyzeGenericArrayType();
    }

    /** 分析WildCardType **/
    private static void analyzeWildCardType(){
        try {
            Field[] fields = WildcardTypeBean.class.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Type type = field.getGenericType();
                String nameString = field.getName();
                System.out.println("下面开始打印" + nameString + "是否具有通配符");
                if (!(type instanceof ParameterizedType)) {
                    System.out.println("---------------------------");
                    continue;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                type = parameterizedType.getActualTypeArguments()[0];
                if (!(type instanceof WildcardType)) {
                    System.out.println("---------------------------");
                    continue;
                }
                WildcardType wildcardType = (WildcardType) type;
                Type[] lowerTypes = wildcardType.getLowerBounds();
                if (lowerTypes != null) {
                    System.out.println("下边界");
                    for (Type lowerType : lowerTypes) {
                        System.out.println(lowerType.getTypeName());
                    }
                }
                Type[] upTypes = wildcardType.getUpperBounds();
                if (upTypes != null) {
                    System.out.println("上边界");
                    for (Type upType : upTypes) {
                        System.out.println(upType.getTypeName());
                    }
                }
                System.out.println("---------------------------");
            }
            Field fieldA = WildcardTypeBean.class.getDeclaredField("a");
            Field fieldB = WildcardTypeBean.class.getDeclaredField("b");
            // 先拿到范型类型
            System.out.println(fieldA.getGenericType() instanceof ParameterizedType);
            System.out.println(fieldB.getGenericType() instanceof ParameterizedType);
            ParameterizedType pTypeA = (ParameterizedType) fieldA.getGenericType();
            ParameterizedType pTypeB = (ParameterizedType) fieldB.getGenericType();
            // 再从范型里拿到通配符类型
            System.out.println(pTypeA.getActualTypeArguments()[0] instanceof WildcardType);
            System.out.println(pTypeB.getActualTypeArguments()[0] instanceof WildcardType);
            WildcardType wTypeA = (WildcardType) pTypeA.getActualTypeArguments()[0];
            WildcardType wTypeB = (WildcardType) pTypeB.getActualTypeArguments()[0];
            // 方法测试
            System.out.println(wTypeA.getUpperBounds()[0]);
            System.out.println(wTypeB.getLowerBounds()[0]);
            // 看看通配符类型到底是什么, 打印结果为: ? extends java.lang.Number
            System.out.println(wTypeA);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    /** 分析GenericArrayType **/
    private static void analyzeGenericArrayType(){
        Method method = GenericArrayTypeBean.class.getDeclaredMethods()[0];
        System.out.println(method);
        // public void test(List<String>[] pTypeArray, T[]
        // vTypeArray,List<String> list, String[] strings, Person[] ints)
        Type[] types = method.getGenericParameterTypes(); // 这是 Method 中的方法
        for (Type type : types) {
            System.out.println(type instanceof GenericArrayType);// 依次输出true，true，false，false，false
        }
    }

    /** 分析TypeVariable **/
    private static void analyzeTypeVariable(){
        TypeVariableBean bean = new TypeVariableBean<FileInputStream, String>();
        try {
            Field fk = TypeVariableBean.class.getDeclaredField("key");
            TypeVariable keyType = (TypeVariable) fk.getGenericType();
            System.out.println("keyType.getName():"+keyType.getName());
            System.out.println("keyType.getGenericDeclaration():"+keyType.getGenericDeclaration());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /** ParameterizedType分析 **/
    private static void analyzeParameterizedType(){
        Field f = null;
        try {
            Field[] fields = ParameterizedTypeBean.class.getDeclaredFields();
            // 打印出所有的 Field 的 TYpe 是否属于 ParameterizedType
            for (int i = 0; i < fields.length; i++) {
                f = fields[i];
                System.out.println(f.getName()
                        + " getGenericType() instanceof ParameterizedType "
                        + (f.getGenericType() instanceof ParameterizedType));
            }
            System.out.println("-------------------getParameterizedTypeMes----------------------");
            getParameterizedTypeMes("map" );
            getParameterizedTypeMes("entry" );


        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    private static void getParameterizedTypeMes(String fieldName) throws NoSuchFieldException {
        Field f;
        f = ParameterizedTypeBean.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        System.out.println(f.getGenericType());
        boolean b=f.getGenericType() instanceof ParameterizedType;
        System.out.println(b);
        if(b){
            ParameterizedType pType = (ParameterizedType) f.getGenericType();
            System.out.println("---pType.getRawType():"+pType.getRawType());
            for (Type type : pType.getActualTypeArguments()) {
                System.out.println(type);
            }
            System.out.println("---pType.getOwnerType():"+pType.getOwnerType()); // null
        }
    }
}
