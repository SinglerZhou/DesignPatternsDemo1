package com.zxg.www.designpatternsdemo.builder;

import android.content.Context;
import android.view.ViewGroup;

/**
 * 导航栏的实现类
 */
public class NavigationBar extends AbsNavigationBar {
    /**
     * Builder模式不能直接new对象,所以用protected
     *
     * @param builder
     */
    protected NavigationBar(Builder builder) {
        super(builder);
    }

    /**
     * 导航栏的builder
     */
    public static class Builder extends AbsNavigationBar.Builder {
        public Builder(Context context, int layoutId, ViewGroup parent) {
            super(context, layoutId, parent);
        }

        @Override
        public NavigationBar create() {
            return new NavigationBar(this);
        }
    }
}
