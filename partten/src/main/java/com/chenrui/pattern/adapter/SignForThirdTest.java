package com.chenrui.pattern.adapter;

import com.chenrui.pattern.adapter.passport.SignForThirdService;

/**
 * 适配器模式：在不改变原有接口前提下，实现兼容
 */
public class SignForThirdTest {
    public static void main(String[] args) {
        SignForThirdService service = new SignForThirdService();
        service.loginforQQ("12345666");
    }
}
