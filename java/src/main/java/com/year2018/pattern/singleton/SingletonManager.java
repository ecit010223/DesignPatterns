package com.year2018.pattern.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: zyh
 * Date: 2018/10/12 15:15
 * 容器实现单例模式
 * 在程序的开始，将多种单例类型注入到一个统一的管理类中，在使用时根据key获取对象对应类型的对象。
 * 这种方便使得我们可以管理多种类型的单例，并且在使用时可以通过统一的接口进行获取操作，降低了用
 * 户的使用成本，也对用户隐藏了具体实现，降低了耦合度。
 * 不管以哪种形式实现单例模式，它们的核心原理都是将构造函数私有化，并且通过静态方法获取一个唯一
 * 的实例，在这个获取的过程中必须保证线程安全、防止反序列化导致重新生成实例对象等问题。选择哪种
 * 实现方式取决于项目本身，如是否是复杂的并发环境、JDK版本是否过低、单例对象的资源消耗等。
 */
public class SingletonManager {
    private static Map<String,Object> objMap = new HashMap<>();

    private SingletonManager(){}

    public static void registerService(String key,Object instance){
        if(!objMap.containsKey(key)){
            objMap.put(key,instance);
        }
    }

    public static Object getService(String key){
        return objMap.get(key);
    }
}
