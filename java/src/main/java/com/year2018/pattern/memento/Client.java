package com.year2018.pattern.memento;

/**
 * author：zyh
 * on: 2018/8/21 21:12
 */
public class Client {
    public static void main(String[] args){
        //构建游戏对象
        CallOfDuty game = new CallOfDuty();
        //打游戏
        game.play();

        Caretaker caretaker = new Caretaker();
        //游戏存档
        caretaker.archive(game.createMemoto());
        // 退出游戏
        game.quit();
        //恢复游戏
        CallOfDuty newGame = new CallOfDuty();
        newGame.restore(caretaker.getMemoto());
    }
}
