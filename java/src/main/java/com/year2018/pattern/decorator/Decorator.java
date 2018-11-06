package com.year2018.pattern.decorator;

/**
 * Author: zyh
 * Date: 2018/8/29 14:26
 */
public abstract class Decorator extends Component {
    /** 持有一个Component对象的引用 **/
    private Component component;

    /**
     * 必要的构造方法，需要一个Component类型的对象
     * @param component
     */
    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void operate() {
        component.operate();
    }
}
