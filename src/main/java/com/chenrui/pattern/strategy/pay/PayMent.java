package com.chenrui.pattern.strategy.pay;

import com.chenrui.pattern.strategy.Order;
import com.chenrui.pattern.strategy.PayStatus;

public interface PayMent {
	public PayStatus pay(Order order);
}
