package com.chenrui.partten.singleton;

/**
 * 饿汉单例模式
 * （1、私有构造函数 2、私有的静态变量 3、公开的静态方法）
 */
public class HungrySingleton {

	private static final HungrySingleton hungrySingleton = new HungrySingleton();

	private HungrySingleton(){

	}
	public static HungrySingleton getHungrySingleton(){
		return hungrySingleton;
	}
}
