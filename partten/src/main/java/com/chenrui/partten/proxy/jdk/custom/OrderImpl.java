package com.chenrui.partten.proxy.jdk.custom;


public class OrderImpl implements Order {
	public int pay() {
		System.out.println("支付订单money ");
		return 0;
	}
}
