package com.zxg.www.designpatternsdemo.singleTon;

/**
 * 双重null判断，synchronized同步锁，volatile 线程之间可见成员变量
 */
public class SingleTonThreadSafe {
    //1.成员变量实例 加volatile关键字，线程间可见
    private static volatile SingleTonThreadSafe mSingleTonThreadSafe;

    private SingleTonThreadSafe() {
    }

    public static SingleTonThreadSafe getInstance() {
        if (mSingleTonThreadSafe == null) {
            //2.第一重null判断，线程A和线程B都进入了if，
            //假设线程A先拿到类的class锁，线程B此时在等待，等A执行完释放锁后，如果没有第二重判断，那么B记录的也是 null，会重复创建对象。
            synchronized (SingleTonThreadSafe.class) {
                if (mSingleTonThreadSafe == null) {
                    mSingleTonThreadSafe = new SingleTonThreadSafe();
                }
            }
        }
        return mSingleTonThreadSafe;
    }
}
