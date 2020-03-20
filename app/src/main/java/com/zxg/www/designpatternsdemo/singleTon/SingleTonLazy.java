package com.zxg.www.designpatternsdemo.singleTon;

/**
 * 懒汉式：等到要使用的时候才创建对象
 */
public class SingleTonLazy {
    private static SingleTonLazy mSingleTonLazy;

    private SingleTonLazy() {
    }

    public static SingleTonLazy getInstance() {
        if (mSingleTonLazy != null) {
            mSingleTonLazy = new SingleTonLazy();
        }
        return mSingleTonLazy;
    }
}
