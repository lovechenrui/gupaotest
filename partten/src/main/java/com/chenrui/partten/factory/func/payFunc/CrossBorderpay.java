package com.chenrui.partten.factory.func.payFunc;

public class CrossBorderpay implements Ipay {
    @Override
    public String pay(String orderid, double amount) {
        String msg ="跨境支付"+amount;
        return msg;
    }
}
