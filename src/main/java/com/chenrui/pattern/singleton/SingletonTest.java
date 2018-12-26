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
		System.out.println("双重检索测试time = " + time);

		/**
		 * 饿汉式测试
		 */
		Runnable task1 = new Runnable() {
			public void run() {
				HungrySingleton singleton = HungrySingleton.getHungrySingleton();
				System.out.println(singleton);
			}
		};
		int threadNum1 = 100;
		long time1 = StartThread.startTaskInOnce(threadNum1,task1);
		System.out.println("饿汉式测试time = " + time1);

		/**
		 * 静态代码块测试
		 */
		Runnable task2 = new Runnable() {
			public void run() {
				StaticBlockSingleton singleton = StaticBlockSingleton.getInstance();
				System.out.println(singleton);
			}
		};
		int threadNum2 = 100;
		long time2 = StartThread.startTaskInOnce(threadNum2,task2);
		System.out.println("饿汉式测试time = " + time2);

		/**
		 * 静态内部类块测试
		 */
		Runnable task3 = new Runnable() {
			public void run() {
				StaticBlockSingleton singleton = StaticBlockSingleton.getInstance();
				System.out.println(singleton);
			}
		};
		int threadNum3 = 100;
		long time3 = StartThread.startTaskInOnce(threadNum3,task3);
		System.out.println("静态内部类块测试 = " + time3);

	}

}
