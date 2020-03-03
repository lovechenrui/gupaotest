package com.chenrui.partten.factory.func.payFunc;

/**
 * 支付接口
 */
public interface Ipay {
    String pay(String orderid,double amount);
}
