package com.zxg.www.designpatternsdemo.singleTon;

/**
 * 静态内部类的单例模式
 */
public class SingleTonStaticInnerClass {
    private SingleTonStaticInnerClass() {
    }

    public static SingleTonStaticInnerClass getInstance() {
        return SingletonHolder.mSingleTonStaticInnerClass;
    }

    public static class SingletonHolder {
        private static SingleTonStaticInnerClass mSingleTonStaticInnerClass = new SingleTonStaticInnerClass();
    }
}
