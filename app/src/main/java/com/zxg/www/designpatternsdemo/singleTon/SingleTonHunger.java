package com.zxg.www.designpatternsdemo.singleTon;

/**
 * 饿汉式：类加载就常见好了对象
 */
public class SingleTonHunger {
    private static final String TAG = "SingleTonHunger";
    private static SingleTonHunger mSingleTonHunger = new SingleTonHunger();

    private SingleTonHunger() {

    }

    public static SingleTonHunger getInstance() {
        return mSingleTonHunger;
    }
}
