package com.year2018.pattern.builder;

/**
 * author：zyh
 * on: 2018/7/31 21:15
 * 具体Builder类，MacbookBuilder
 */
public class MacBookBuilder extends Builder {
    private Computer mComputer = new MacBook();

    @Override
    public void buildBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    public void buildOS() {
        mComputer.setOS();
    }

    @Override
    public Computer create() {
        return mComputer;
    }
}
