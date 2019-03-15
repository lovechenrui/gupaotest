package com.chenrui.pattern.strategy.pay;

import com.chenrui.pattern.strategy.Order;
import com.chenrui.pattern.strategy.PayStatus;

public class Alipay implements PayMent {
	@Override
	public PayStatus pay(Order order) {
		System.out.printf("用户：%s 支付：%f",order.getUserid(),order.getAmount());
		return new PayStatus("200","支付成功","");
	}
}
