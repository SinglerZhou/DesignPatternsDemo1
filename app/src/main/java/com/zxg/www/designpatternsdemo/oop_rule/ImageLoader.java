package com.zxg.www.designpatternsdemo.oop_rule;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * //需求：实现图片加载，并将图片缓存起来
 */
public class ImageLoader {

    private LruCache<String, Bitmap> mImageLurCase;//图片缓存

    private ImageLoader() {
        initImageCache();
    }

    private void initImageCache() {
        //计算可使用的最大内存
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取四分之一的可用内存作为缓存
        int cacheSize = maxMemory / 4;
        mImageLurCase = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return super.sizeOf(key, value);
            }
        };
    }
}
