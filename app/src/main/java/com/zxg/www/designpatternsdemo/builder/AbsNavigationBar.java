package com.zxg.www.designpatternsdemo.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 导航栏的基类
 */
public class AbsNavigationBar implements INavigation {
    private Builder mBuilder;
    private View mNavigationBar;

    /**
     * Builder模式不能直接new对象,所以用protected
     */
    protected AbsNavigationBar(Builder builder) {
        this.mBuilder = builder;
        createNavigationBar();
    }

    @Override
    public void createNavigationBar() {
        //创建
        mNavigationBar = LayoutInflater.from(mBuilder.mContext).inflate(mBuilder.mLayoutId, mBuilder.mParent, false);
        //添加到父布局
        attachParent(mNavigationBar, mBuilder.mParent);
        //绑定参数
        attachNavigationParams();
    }

    /**
     * 绑定参数
     */
    @Override
    public void attachNavigationParams() {

    }

    /**
     * 将navigation添加到父布局
     *
     * @param navigationBar
     * @param parent
     */
    @Override
    public void attachParent(View navigationBar, ViewGroup parent) {
        parent.addView(navigationBar, 0);
    }


    public Builder getBuilder() {
        return mBuilder;
    }

    /**
     * Builder构建类
     */
    public static abstract class Builder {
        private Context mContext;
        private int mLayoutId;
        private ViewGroup mParent;

        public Builder(Context context, int layoutId, ViewGroup parent) {
            this.mContext = context;
            this.mLayoutId = layoutId;
            this.mParent = parent;
        }

        public abstract AbsNavigationBar create();

    }


}
