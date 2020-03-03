package com.chenrui.partten.factory.func.payFunc;

public class WechatpayFactory implements PayFactory {
    @Override
    public Ipay createPay() {
        return new Wechatpay();
    }
}
