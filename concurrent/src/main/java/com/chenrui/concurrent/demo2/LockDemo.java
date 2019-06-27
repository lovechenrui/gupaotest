package com.chenrui.concurrent.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	static Lock lock = new ReentrantLock();
	static int num = 0;
	public static void incr(){
		lock.lock();
		num ++;
		lock.unlock();
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				LockDemo.incr();
			}
		});
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				LockDemo.incr();
			}
		});
		thread.start();
		thread1.start();

	}
}
