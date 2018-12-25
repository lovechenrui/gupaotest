package com.chenrui.pattern.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		/**
		 * 双重检索测试
		 */
		Runnable task = new Runnable() {
			public void run() {
				DoubleCheckSingleton singleton = DoubleCheckSingleton.getInstance();
				System.out.println(singleton);
			}
		};
		int threadNum = 100;
		long time = StartThread.startTaskInOnce(threadNum,task);
		System.out.println("time = " + time);

		/**
		 * 饿汉式测试
		 */

	}
}
