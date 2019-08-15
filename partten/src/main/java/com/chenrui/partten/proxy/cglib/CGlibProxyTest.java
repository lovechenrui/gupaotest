package com.chenrui.partten.proxy.cglib;

public class CGlibProxyTest {
	public static void main(String[] args) {
		Order orderProxy = (Order) new CGlibProxy().getInstance(Order.class);
		orderProxy.pay(10);
	}
}
