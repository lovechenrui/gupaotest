package com.chenrui.partten.strategy.pay;

import com.chenrui.partten.strategy.Order;
import com.chenrui.partten.strategy.PayStatus;

public abstract class PayMent {
	public abstract String getPayType();
	public abstract double queryBalance(String uid);
	public PayStatus pay(Order order){
		if(queryBalance(order.getUserid()) >= order.getAmount()){
				return new PayStatus("200","支付成功","");
		}
			return new PayStatus("500","支付失败","余额不足");
	}
}
