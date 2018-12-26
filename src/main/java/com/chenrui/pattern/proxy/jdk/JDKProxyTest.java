package com.chenrui.pattern.proxy.jdk;

public class JDKProxyTest {
	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Order order = (Order) new JDKProxy().getInstance(new OrderImpl());
		System.out.println("order = [" + order + "]");
		order.pay(10);
	}
}
