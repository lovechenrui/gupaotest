package com.chenrui.partten.proxy.jdk.custom;


public class OrderImpl implements Order {
	public int pay() {
		System.out.println("支付订单money ");
		return 123456;
	}
	public int find(String orderid){
		System.out.println("查找訂單"+orderid);
		return 1234;
	}
}
