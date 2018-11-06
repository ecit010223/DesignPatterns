package com.year2018.pattern.memento;

/**
 * author：zyh
 * on: 2018/8/21 21:00
 * 使命召唤游戏
 */
public class CallOfDuty {
    private int mCheckPoint = 1;
    private int mLifeValue = 100;
    private String mWeapon = "沙漠之鹰";

    /** 玩游戏 **/
    public void play(){
        System.out.println("玩游戏："+String.format("第%d关",mCheckPoint)+" 奋战杀敌中");
        mLifeValue -=10;
        System.out.println("进度升级啦");
        mCheckPoint++;
        System.out.println("到达 "+String.format("第%d关",mCheckPoint));
    }

    /** 退出游戏 **/
    public void quit(){
        System.out.println("-----------------------");
        System.out.println("退出前的游戏属性："+this.toString());
        System.out.println("退出游戏");
        System.out.println("-----------------------");
    }

    /**创建备忘录 **/
    public Memoto createMemoto(){
        Memoto memoto = new Memoto();
        memoto.mCheckPoint = mCheckPoint;
        memoto.mLifeValue = mLifeValue;
        memoto.mWeapon = mWeapon;
        return memoto;
    }

    /** 恢复游戏 **/
    public void restore(Memoto memoto){
        this.mCheckPoint = memoto.mCheckPoint;
        this.mLifeValue = memoto.mLifeValue;
        this.mWeapon = memoto.mWeapon;
        System.out.println("恢复后的游戏属性："+this.toString());
    }

    public int getCheckPoint() {
        return mCheckPoint;
    }

    public void setCheckPoint(int checkPoint) {
        mCheckPoint = checkPoint;
    }

    public int getLifeValue() {
        return mLifeValue;
    }

    public void setLifeValue(int lifeValue) {
        mLifeValue = lifeValue;
    }

    public String getWeapon() {
        return mWeapon;
    }

    public void setWeapon(String weapon) {
        mWeapon = weapon;
    }

    @Override
    public String toString() {
        return "CallOfDuty [mCheckPoint="+mCheckPoint+",mLifeValue="+mLifeValue+",mWeapon="+mWeapon+"]";
    }
}
