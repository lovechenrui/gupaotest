package com.chenrui.pattern.strategy.pay;

import com.chenrui.pattern.strategy.Order;
import com.chenrui.pattern.strategy.PayStatus;

public class Wxpay implements PayMent {
	@Override
	public PayStatus pay(Order order) {
		System.out.printf("用户：%d 支付：%f",order.getUserid(),order.getAmount());
		return new PayStatus("200","支付成功","");
	}
}
