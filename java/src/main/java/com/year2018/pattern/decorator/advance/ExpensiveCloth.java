package com.year2018.pattern.decorator.advance;

/**
 * Author: zyh
 * Date: 2018/8/29 14:39
 */
public class ExpensiveCloth extends PersonCloth {
    public ExpensiveCloth(Person person) {
        super(person);
    }

    /**
     * 穿短袖
     */
    private void dressShirt(){
        System.out.println("穿件短袖");
    }

    /**
     * 穿皮衣
     */
    private void dressLeather(){
        System.out.println("穿件皮衣");
    }

    /**
     * 穿牛仔裤
     */
    private void dressJean(){
        System.out.println("穿条牛仔裤");
    }

    @Override
    public void dressed() {
        super.dressed();
        dressShirt();
        dressLeather();
        dressJean();
    }
}
