package com.chenrui.partten.factory.func.payFunc;

public class UnionpayFactory implements PayFactory {
    @Override
    public Ipay createPay() {
        return new Unionpay();
    }
}
