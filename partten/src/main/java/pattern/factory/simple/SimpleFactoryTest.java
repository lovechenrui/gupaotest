package com.chenrui.pattern.factory.simple;

public class SimpleFactoryTest {
	public static void main(String args[]){
		/**
		 * 小作坊自己生产各种品牌的牛奶
		 * 需要用户输入
		 */
		Simplefactory simplefactory = new Simplefactory();
		System.out.println(simplefactory.getMilk("mengniu"));
	}
}
