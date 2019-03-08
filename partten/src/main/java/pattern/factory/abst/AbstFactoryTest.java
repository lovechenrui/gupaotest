package com.chenrui.pattern.factory.abst;

/**
 * 同意管理，用户可以选择
 */
public class AbstFactoryTest {
	public static void main(String args[]){
		MilkAbstFactory milkAbstFactory = new MilkAbstFactory();
		System.out.println(milkAbstFactory.getTelunsu());
	}
}
