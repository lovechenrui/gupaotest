package com.chenrui.pattern.strategy;

public class Order {
	private String userid;
	private String orderid;
	private double amount;

	public Order(String userid, String orderid, double amount) {
		this.userid = userid;
		this.orderid = orderid;
		this.amount = amount;
	}

	public PayStatus pay(PayType payType){
		PayStatus payStatus =payType.getPayMent().pay(this);
		return payStatus;
	}
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
