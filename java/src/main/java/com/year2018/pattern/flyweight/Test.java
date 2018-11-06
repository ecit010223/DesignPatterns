package com.year2018.pattern.flyweight;

/**
 * Author: zyh
 * Date: 2018/8/29 16:26
 */
public class Test {
    public static void main(String[] args){
        Ticket ticket01 = TicketFactory.getTicket("北京","青岛");
        ticket01.showTicketInfo("上铺");
        Ticket ticket02 = TicketFactory.getTicket("北京","青岛");
        ticket02.showTicketInfo("下铺");
        Ticket ticket03 = TicketFactory.getTicket("北京","青岛");
        ticket03.showTicketInfo("坐票");
    }
}
