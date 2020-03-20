package com.zxg.www.designpatternsdemo.oop_rule.lsp_rule;

/**
 * 窗口类：说明里氏替换原则lsp
 */
public class Window {
    public void show(View child) {
        child.draw();
    }
}
