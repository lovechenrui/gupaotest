package com.chenrui.pattern.strategy.pay;

import com.chenrui.pattern.strategy.Order;
import com.chenrui.pattern.strategy.PayStatus;

public class Alipay extends PayMent {
	@Override
	public String getPayType() {
		return "支付宝";
	}

	@Override
	public double queryBalance(String uid) {
		return 1000;
	}
}
