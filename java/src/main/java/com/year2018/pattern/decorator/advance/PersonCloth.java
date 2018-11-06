package com.year2018.pattern.decorator.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 14:37
 */
public class PersonCloth extends Person {
    /** 保持一个Person类的引用 **/
    protected Person person;

    public PersonCloth(Person person){
        this.person = person;
    }

    @Override
    public void dressed() {
        this.person.dressed();
    }
}
