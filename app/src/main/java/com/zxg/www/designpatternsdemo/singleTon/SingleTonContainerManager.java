package com.zxg.www.designpatternsdemo.singleTon;

import java.util.HashMap;

/**
 * 容器管理单例设计模式
 */
public class SingleTonContainerManager {
    private static HashMap<String,Object> mSingleMap= new HashMap<>();
    private SingleTonContainerManager(){}
    static {
        mSingleMap.put("activity_manager",new SingleTonContainerManager());
    }
    public static Object getService(String serviceName){
        return mSingleMap.get(serviceName);
    }
}
