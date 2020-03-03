package com.chenrui.partten.factory.func.payFunc;

public class Unionpay implements Ipay {
    @Override
    public String pay(String orderid, double amount) {
        String msg ="银联支付"+amount;
        return msg;
    }
}
