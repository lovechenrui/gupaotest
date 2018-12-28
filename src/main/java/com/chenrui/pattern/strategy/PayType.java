package com.chenrui.pattern.strategy;

import com.chenrui.pattern.strategy.pay.Alipay;
import com.chenrui.pattern.strategy.pay.PayMent;
import com.chenrui.pattern.strategy.pay.Wxpay;

public enum  PayType {
	ALIPAY(new Alipay()),WXPAY(new Wxpay());

	private PayMent payMent;

	PayType(PayMent payMent) {
		this.payMent = payMent;
	}
	public PayMent getPayMent(){
		return this.payMent;
	}
}
