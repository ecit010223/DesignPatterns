package com.year2018.effective_java.item30;

/**
 * Author: zyh
 * Date: 2018/10/25 11:08
 */
public class WeightTable {
    public static void main(String[] args) {
        double earthWeight = 100;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values())
            System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
    }
}
