package com.year2018.pattern.mvp;

/**
 * Author: zyh
 * Date: 2018/8/29 17:17
 */
public interface ViewInterface<T> {
    /**
     * 成功获取数据
     * @param tag  标记哪个请求获取的数据
     * @param result
     */
    void fetchDataFinished(int tag,T result);
    /** 获取数据失败
     * @param tag 标记哪次请求失败了
     **/
    void fetchDataFailure(int tag,T failure);
}
