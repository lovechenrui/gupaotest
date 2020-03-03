package com.chenrui.partten.factory.func.payFunc;

public class Test {
    public static void main(String[] args) {
        PayFactory payFactory = new AlipayFactory();
        String rs = payFactory.createPay().pay("12345",30.4);
        System.out.println(rs);
        payFactory = new WechatpayFactory();
        String rs1 = payFactory.createPay().pay("12345",30.4);
        System.out.println(rs1);
    }
}
