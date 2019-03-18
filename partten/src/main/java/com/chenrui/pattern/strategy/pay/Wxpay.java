package com.chenrui.pattern.strategy.pay;

import com.chenrui.pattern.strategy.Order;
import com.chenrui.pattern.strategy.PayStatus;

public class Wxpay extends PayMent {
	@Override
	public String getPayType() {
		return "微信支付";
	}

	@Override
	public double queryBalance(String uid) {
		return 500;
	}
}
