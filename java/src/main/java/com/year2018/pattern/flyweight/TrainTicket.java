package com.year2018.pattern.flyweight;

import java.util.Random;

/**
 * Author: zyh
 * Date: 2018/8/29 16:15
 * 火车票
 */
public class TrainTicket implements Ticket {
    /** 始发地 **/
    public String from;
    /** 目的地 **/
    public String to;
    public int price;

    public TrainTicket(String from, String to){
        this.from = from;
        this.to = to;
    }

    /**
     * @param bunk 铺位
     */
    @Override
    public void showTicketInfo(String bunk) {
        price = new Random().nextInt(300);
        System.out.println("购买从 "+from+" 到 "+to+" 的 "+bunk+" 火车票"+",价格："+price);
    }
}
