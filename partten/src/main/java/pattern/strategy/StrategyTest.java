package com.chenrui.pattern.strategy;

/**
 * 策略模式：用户只能在已有的支付方式中选择
 */
public class StrategyTest {
	public static void main(String[] args) {
		Order order = new Order("1234","1111111",10);
		PayStatus status = order.pay(PayType.ALIPAY);
	}
}
