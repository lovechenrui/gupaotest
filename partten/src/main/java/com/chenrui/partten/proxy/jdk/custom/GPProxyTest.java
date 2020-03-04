package com.chenrui.partten.proxy.jdk.custom;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.lang.reflect.Method;

public class GPProxyTest {

	public static void main(String[] args) {

		Order order = (Order)new CustomProxy().getInstance(new OrderImpl());
		order.pay();
		order.find("12345");
//		String a ="hello";
//		System.out.println(order.pay());
//		System.out.println(order.find("12345"));

//		$Proxy0 s  =new $Proxy0(new CustomProxy());
//		s.find("1234");
	}
}
