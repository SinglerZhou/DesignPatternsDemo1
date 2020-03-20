package com.zxg.www.designpatternsdemo;


/**
 * 匹配字符串
 */
public class ContainString {
    private static final String TAG = "ContainString";

    public static void main(String args[]) {
        boolean ghj = match("qwertyuiopasdfghjklzxcvbnm,.", "ghj");
//        Log.i(TAG, "zxglog main: 是否包含：" + ghj);
        System.out.println("zxglog main: 是否包含：" + ghj);
    }

    /*****
     * Java代码实现朴素模式匹配,效率偏低
     *
     * @param stringS 主串S
     * @param stringT 模式串T
     */
    public static boolean match(String stringS, String stringT) {
        char[] charsS = stringS.toCharArray();
        char[] charsT = stringT.toCharArray();
        for (int i = 0, sizeI = charsS.length - charsT.length; i <= sizeI; i++) {
            for (int j = 0, sizeJ = charsT.length; j < sizeJ; j++) {
                if (charsS[i + j] != charsT[j]) {
                    break;
                }
                if (sizeJ - 1 == j) {

                    return true;
                }
            }
        }
        return false;
    }
}
