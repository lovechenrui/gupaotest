package com.chenrui.partten.adapter;

import com.chenrui.partten.adapter.passport.SignForThirdService;

/**
 * 适配器模式：在不改变原有接口前提下，实现兼容
 */
public class SignForThirdTest {
    public static void main(String[] args) {
        SignForThirdService service = new SignForThirdService();
        service.loginforQQ("12345666");
    }
}
