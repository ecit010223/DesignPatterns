package com.year2018.pattern.decorator.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 14:42
 */
public class CheapCloth extends PersonCloth {
    public CheapCloth(Person person) {
        super(person);
    }

    /**
     * 穿短裤
     */
    public void dressShorts(){
        System.out.println("穿条短裤");
    }

    @Override
    public void dressed() {
        super.dressed();
        dressShorts();
    }
}
