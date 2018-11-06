package com.year2018.pattern.flyweight;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: zyh
 * Date: 2018/8/29 16:18
 * 在TicketFactory添加了一个Map容器，并且以出发地+“-”+目的地为键，以车票对象作为值存储车票对象。
 * 这个map的键就是我们说的内部状态，在这里就是出发地、橫杠、目的地拼接起来的字符串，如果没有缓存
 * 则创建一个对象，并且将这个对象缓存到map中，下次再有这类请求时则直接从缓存中获取。这样即使有1000
 * 个请求北京到青岛的车票信息，那么出发地是北京、目的地是青岛的车票对象只有一个。这样就从这个对象
 * 从1000减到了1个，避免了大量的内存占用及频繁的GC操作。
 */
public class TicketFactory {
    static Map<String,Ticket> sTicketMap = new ConcurrentHashMap<>();

    public static Ticket getTicket(String from,String to){
        String key = from+"-"+to;
        if(sTicketMap.containsKey(key)){
            System.out.println("使用缓存 ==> "+key);
            return sTicketMap.get(key);
        }else {
            System.out.println("创建对象 ==> "+key);
            Ticket ticket = new TrainTicket(from,to);
            sTicketMap.put(key,ticket);
            return ticket;
        }
    }
}
