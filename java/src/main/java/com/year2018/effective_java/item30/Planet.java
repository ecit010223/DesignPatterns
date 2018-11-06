package com.year2018.effective_java.item30;

/**
 * Author: zyh
 * Date: 2018/10/25 11:08
 * 为了将数据与枚举常量关联起来，得声明实例域，并编写一个带有数据并将数据保存在域中的构造器。
 */
public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24,6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    NEPTUNE(1.024e+26,2.477e7);

    /** 行星质量 **/
    private final double mass; // In kilograms
    /** 行星半径 **/
    private final double radius; // In meters
    /** 行星表面重力 **/
    private final double surfaceGravity; // In m / s^2

    // Universal gravitational constant in m^3 / kg s^2
    private static final double G = 6.67300E-11;

    // Constructor
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    /** 得到某物体的在该行星上的重量 **/
    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; // F = ma
    }
}
