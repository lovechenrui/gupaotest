package com.chenrui.partten.strategy.pay;

import com.chenrui.partten.strategy.Order;
import com.chenrui.partten.strategy.PayStatus;

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
