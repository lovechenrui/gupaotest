package com.chenrui.partten.proxy.cglib;

public class Order {
	public int pay(double money) {
		System.out.println("支付订单money = [" + money + "]");
		return 0;
	}
}
