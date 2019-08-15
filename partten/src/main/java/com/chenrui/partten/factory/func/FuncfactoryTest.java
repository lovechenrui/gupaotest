package com.chenrui.partten.factory.func;


public class FuncfactoryTest {
	public static void main(String args[]){
		/**
		 * 大工厂，可以找不同的厂家生产牛奶
		 * 不需要用户输入，只需要告诉需要什么牌子的牛奶
		 */
		Funcfactory funcfactory = new YiliFuncfactory();
		System.out.println(funcfactory.getMilk());
	}
}
