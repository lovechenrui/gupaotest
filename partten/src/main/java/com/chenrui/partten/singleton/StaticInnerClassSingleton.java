package com.chenrui.partten.singleton;

/**
 * 静态内部类
 */
public class StaticInnerClassSingleton {
	private StaticInnerClassSingleton(){

	}
	public static StaticInnerClassSingleton getInstance(){
		return InnerSingleton.instance;
	}
	private static class InnerSingleton{
		private static final StaticInnerClassSingleton instance  = new StaticInnerClassSingleton();
	}
}
