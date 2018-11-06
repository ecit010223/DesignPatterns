package com.year2018.annotation;

import com.year2018.annotation.custom.FruitColor;
import com.year2018.annotation.custom.FruitName;
import com.year2018.annotation.custom.FruitProvider;

/**
 * Author: zyh
 * Date: 2018/10/26 9:32
 * 定义了注解，并在需要的时候给相关类、类属性加上注解信息，如果没有响应的注解信息处理流程，注解可以说是没
 * 有实用价值，如何让注解真正的发挥作用，主要就在于注解处理方法。
 */
public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor=FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }
    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }
    public String getAppleName() {
        return appleName;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }
    public void displayName(){
        System.out.println("水果的名字是：苹果");
    }
}
