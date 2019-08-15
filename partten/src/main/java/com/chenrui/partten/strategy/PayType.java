package com.chenrui.partten.strategy;

import com.chenrui.partten.strategy.pay.Alipay;
import com.chenrui.partten.strategy.pay.PayMent;
import com.chenrui.partten.strategy.pay.Wxpay;

import java.util.HashMap;
import java.util.Map;

public class  PayType {
	/*ALIPAY(new Alipay()),WXPAY(new Wxpay());

	private PayMent payMent;

	PayType(PayMent payMent) {
		this.payMent = payMent;
	}
	public PayMent getPayMent(){
		return this.payMent;
	}*/

	public static final String ALI_PAY ="alipay";
	public static final String WX_PAY ="weixinpay";
	private static Map<String,PayMent> payMentMap = new HashMap<String,PayMent>();
	static {
		payMentMap.put(ALI_PAY,new Alipay());
		payMentMap.put(WX_PAY,new Wxpay());
	}
	public static PayMent getPayMent(String payType){
		if(payMentMap.containsKey(payType)){
			return payMentMap.get(payType);
		}else{
			return payMentMap.get(ALI_PAY);
		}
	}
}
