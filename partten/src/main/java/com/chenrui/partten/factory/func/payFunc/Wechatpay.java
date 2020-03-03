package com.chenrui.partten.factory.func.payFunc;

public class Wechatpay implements Ipay {
    @Override
    public String pay(String orderid, double amount) {
        String msg ="微信支付"+amount;
        return msg;
    }
}
