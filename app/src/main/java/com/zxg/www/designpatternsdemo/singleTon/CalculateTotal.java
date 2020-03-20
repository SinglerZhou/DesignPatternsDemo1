package com.zxg.www.designpatternsdemo.singleTon;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

public class CalculateTotal {

    private static final String TAG = "CalculateTotal";

    public static void main(String[] args) {

    }

    private static void calculateEggNum() {
        int total = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i % 1 == 0 && i % 2 == 1 && i % 3 == 0 && i % 4 == 1 && i % 5 == 1 && i % 6 == 3 && i % 7 == 0 && i % 8 == 1 && i % 9 == 0) {
                System.out.println("鸡蛋总数是：" + i);
                total++;
            }
        }
        System.out.println("符合条件的总个数：" + total);
    }



}
