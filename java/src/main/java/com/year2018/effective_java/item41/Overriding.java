package com.year2018.effective_java.item41;

/**
 * Author: zyh
 * Date: 2018/11/1 10:07
 * 方法的覆盖
 * 选择被覆盖方法是在运行时决定的
 */

class Wine {
    String name() {
        return "wine";
    }
}

class SparklingWine extends Wine {
    @Override
    String name() {
        return "sparkling wine";
    }
}

class Champagne extends SparklingWine {
    @Override
    String name() {
        return "champagne";
    }
}

public class Overriding {
    public static void main(String[] args) {
        Wine[] wines = { new Wine(), new SparklingWine(), new Champagne() };
        for (Wine wine : wines)
            System.out.println(wine.name());
    }
}
