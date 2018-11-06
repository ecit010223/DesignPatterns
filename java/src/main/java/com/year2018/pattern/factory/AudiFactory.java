package com.year2018.pattern.factory;

/**
 * 作者：张玉辉 on 2018/4/19 21:46.
 */
public abstract class AudiFactory {
    public abstract <T extends AudiCar> T createAudiCar(Class<T> clz);
}
