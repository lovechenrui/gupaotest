package com.chenrui.partten.singleton;

/**
 * 静态代码块
 */
public class StaticBlockSingleton {

	private static StaticBlockSingleton instance;

	static {
		instance = new StaticBlockSingleton();
	}
	private StaticBlockSingleton(){

	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}
}
