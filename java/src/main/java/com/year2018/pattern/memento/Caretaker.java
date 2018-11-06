package com.year2018.pattern.memento;

/**
 * author：zyh
 * on: 2018/8/21 21:10
 * 负责管理Memoto
 */
public class Caretaker {
    /** 备忘录 **/
    Memoto mMemoto;

    /** 存档 **/
    public void archive(Memoto memoto){
        this.mMemoto = memoto;
    }

    /** 获取存档 **/
    public Memoto getMemoto(){
        return mMemoto;
    }
}
