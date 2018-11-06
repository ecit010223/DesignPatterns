package com.year2018.pattern.abstract_factory;


/**
 * 作者：张玉辉 on 2018/4/19 21:41.
 */
public class Q7Factory extends CarFactory {
    @Override
    public ITire createTire() {
        return new SUVTire();
    }

    @Override
    public IEngine createEngine() {
        return new ImportEngine();
    }

    @Override
    public IBrake createBrake() {
        return new SeniorBrake();
    }
}
