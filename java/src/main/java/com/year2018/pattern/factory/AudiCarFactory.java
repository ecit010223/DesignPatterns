package com.year2018.pattern.factory;

/**
 * 作者：张玉辉 on 2018/4/19 21:47.
 */
public class AudiCarFactory extends AudiFactory {
    @Override
    public <T extends AudiCar> T createAudiCar(Class<T> clz) {
        AudiCar car = null;
        try {
            car = (AudiCar)Class.forName(clz.getName()).newInstance();
        }catch (Exception e){
            e.printStackTrace();
        }
        return (T) car;
    }
}
