package com.zxg.www.designpatternsdemo.manager;

import android.app.Activity;

import java.util.Stack;

public class ActivityManager {
    private static volatile ActivityManager mInstance;
    //集合管理Activity，Stack是线程安全的
    private Stack<Activity> mActivities;

    private ActivityManager() {
        mActivities = new Stack<>();
    }

    public static ActivityManager getInstance() {
        if (mInstance == null) {
            synchronized (ActivityManager.class) {
                if (mInstance == null) {
                    mInstance = new ActivityManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 添加activity到集合中
     *
     * @param activity
     */
    public void attach(Activity activity) {
        mActivities.add(activity);
    }

    /**
     * 解绑，防止内存泄漏
     *
     * @param activity
     */
    public void detach(Activity activity) {
        for (int i = 0; i < mActivities.size(); i++) {
            if (activity == mActivities.get(i)) {
                mActivities.remove(activity);
                i--;//需要注意，i--
            }
        }
    }

    /**
     * 关闭activity
     *
     * @param finishActivity
     */
    public void finish(Activity finishActivity) {
        for (int i = 0; i < mActivities.size(); i++) {
            if (finishActivity == mActivities.get(i)) {
                mActivities.remove(finishActivity);
                i--;
            }
        }
    }

    /**
     * 根据类名，关闭activity
     *
     * @param finishActivityClass
     */
    public void finish(Class<? extends Activity> finishActivityClass) {
        for (int i = 0; i < mActivities.size(); i++) {
            if (mActivities.get(i).getClass().getCanonicalName() == finishActivityClass.getCanonicalName()) {
                mActivities.remove(finishActivityClass);
                i--;
            }
        }
    }

    /**
     * 退出当前应用
     */
    public void exitApplication() {

    }

    /**
     * 获取当前activity
     */
    public Activity getCurrentActivity() {
        return mActivities.lastElement();
    }
}
