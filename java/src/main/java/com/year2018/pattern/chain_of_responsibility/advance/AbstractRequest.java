package com.year2018.pattern.chain_of_responsibility.advance;

/**
 * author：zyh
 * on: 2018/8/20 20:21
 */
public abstract class AbstractRequest {
    /** 处理对象 **/
    private Object obj;

    public AbstractRequest(Object obj){
        this.obj = obj;
    }

    /**
     * 获取处理的内容对象
     * @return 具体的处理对象
     */
    public Object getContent(){
        return obj;
    }

    /**
     * 获取请求级别
     * @return 请求级别
     */
    public abstract int getRequestLevel();
}
