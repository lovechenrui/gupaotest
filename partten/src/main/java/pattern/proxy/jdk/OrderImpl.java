package com.chenrui.pattern.proxy.jdk;

public class OrderImpl implements Order {
	public int pay(double money) {
		System.out.println("支付订单money = [" + money + "]");
		return 0;
	}
}
