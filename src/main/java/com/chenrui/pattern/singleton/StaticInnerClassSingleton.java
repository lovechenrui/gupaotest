package com.chenrui.pattern.singleton;

/**
 * 静态内部类
 */
public class StaticInnerClassSingleton {
	private StaticInnerClassSingleton(){

	}
	public static StaticInnerClassSingleton getInstance(){
		return StaticInnerClassSingleton.InnerSingleton.instance;
	}
	private static class InnerSingleton{
		private static final StaticInnerClassSingleton instance  = new StaticInnerClassSingleton();
	}
}
