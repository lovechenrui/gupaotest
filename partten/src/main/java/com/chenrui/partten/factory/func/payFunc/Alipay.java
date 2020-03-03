package com.chenrui.partten.factory.func.payFunc;

public class Alipay implements Ipay {
    @Override
    public String pay(String orderid, double amount) {
        String msg ="支付宝支付"+amount;
        return msg;
    }
}
