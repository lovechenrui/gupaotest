package com.chenrui.partten.strategy.pay;

import com.chenrui.partten.strategy.Order;
import com.chenrui.partten.strategy.PayStatus;

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
