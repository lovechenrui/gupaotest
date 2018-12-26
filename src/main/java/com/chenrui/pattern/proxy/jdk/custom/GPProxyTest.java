package com.chenrui.pattern.proxy.jdk.custom;

import com.sun.org.apache.xpath.internal.operations.Or;

public class GPProxyTest {

	public static void main(String[] args) {

		Order order = (Order)new CustomProxy().getInstance(new OrderImpl());
		order.pay();
	}
}
