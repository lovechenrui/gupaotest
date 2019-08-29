package com.chenrui.concurrent.deadLock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁demo
 */
public class DeadLockDemo {
	static class InnerDeadLock implements Runnable {
		private DeadLockDemo locka;
		private DeadLockDemo lockb;

		public InnerDeadLock(DeadLockDemo locka, DeadLockDemo lockb) {
			this.locka = locka;
			this.lockb = lockb;
		}
		@Override
		public void run() {
			while(true) {
				synchronized (locka) {
					System.out.println(Thread.currentThread().getName() + "获取锁");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lockb) {
						System.out.println(Thread.currentThread().getName() + "等待锁");
					}
				}
			}
		}

	}
	public static void main(String[] args) {
		DeadLockDemo locka = new DeadLockDemo();
		DeadLockDemo lockb = new DeadLockDemo();
		Thread threada = new Thread(
			new InnerDeadLock(locka,lockb)
		,"线程A");

		Thread threadb = new Thread(
			new InnerDeadLock(lockb,locka)
		,"线程B");
		threada.start();
		threadb.start();
	}


}
