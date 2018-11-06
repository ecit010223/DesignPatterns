package com.year2018.annotation;

import com.year2018.annotation.custom.FruitColor;
import com.year2018.annotation.custom.FruitName;
import com.year2018.annotation.custom.FruitProvider;

import java.lang.reflect.Field;

/**
 * Author: zyh
 * Date: 2018/10/26 9:35
 * 注解处理器
 */
public class FruitInfoUtil {
    public static void main(String[] args){
        getFruitInfo(Apple.class);
    }

    public static void getFruitInfo(Class<?> clazz){
        String strFruitName=" 水果名称：";
        String strFruitColor=" 水果颜色：";
        String strFruitProvider="供应商信息：";

        Field[] fields = clazz.getDeclaredFields();

        for(Field field :fields){
            //判断该程序元素上是否包含指定类型的注解
            if(field.isAnnotationPresent(FruitName.class)){
                //返回该程序元素上存在的、指定类型的注解，如果该类型注解不存在，则返回null
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                strFruitName=strFruitName+fruitName.value();
                System.out.println(strFruitName);
            }
            else if(field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor= (FruitColor) field.getAnnotation(FruitColor.class);
                strFruitColor=strFruitColor+fruitColor.fruitColor().toString();
                System.out.println(strFruitColor);
            }
            else if(field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider= (FruitProvider) field.getAnnotation(FruitProvider.class);
                strFruitProvider=" 供应商编号："+fruitProvider.id()+",供应商名称："+fruitProvider.name()+", 供应商地址："+fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }
    }
}
