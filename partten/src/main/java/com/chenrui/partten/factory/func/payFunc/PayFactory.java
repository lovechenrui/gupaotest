package com.chenrui.partten.factory.func.payFunc;

/**
 * 通过特定的工厂生产产品。通过特定的支付方式支付
 */
public interface  PayFactory {
        Ipay createPay();
}