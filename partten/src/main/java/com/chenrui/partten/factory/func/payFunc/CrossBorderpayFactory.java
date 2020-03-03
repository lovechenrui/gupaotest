package com.chenrui.partten.factory.func.payFunc;

public class CrossBorderpayFactory implements PayFactory {
    @Override
    public Ipay createPay() {
        return new CrossBorderpay();
    }
}
