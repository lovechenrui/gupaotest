package com.chenrui.partten.factory.func.payFunc;

public class AlipayFactory implements PayFactory {
    @Override
    public Ipay createPay() {
        return new Alipay();
    }
}
